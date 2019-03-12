package com.mymagazine.service.impl;

import com.mymagazine.bean.User;
import com.mymagazine.bean.UserCondition;
import com.mymagazine.dao.UserMapper;
import com.mymagazine.exception.TipException;
import com.mymagazine.service.IUserService;
import com.mymagazine.util.MagazineUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

//@CacheConfig(cacheNames = "users")
@Service
public class UserService implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public Integer insertUser(User user) {
        Integer uid = null;
        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getEmail())) {
//            用户密码加密
            String encodePwd = MagazineUtil.MD5encode(user.getUsername() + user.getPassword());
            user.setPassword(encodePwd);
            userMapper.insertSelective(user);
        }
        return user.getUid();
    }

    //@Cacheable(keyGenerator = "magazineCacheKey", unless = "#result==null")
    @Override
    public User queryUserById(Integer uid) {
        User user = null;
        if (uid != null) {
            user = userMapper.selectByPrimaryKey(uid);
        }
        return user;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        UserCondition userCondition = new UserCondition();
        UserCondition.Criteria criteria = userCondition.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = userMapper.countByCondition(userCondition);
        if (count < 1) {
            throw new TipException("不存在该用户");
        }
        String pwd = MagazineUtil.MD5encode(username + password);
        criteria.andPasswordEqualTo(pwd);
        List<User> userVos = userMapper.selectByCondition(userCondition);
        if (userVos.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        return userVos.get(0);
    }

    @Override
    @Transactional
    public void updateByUid(User user) {
        if (null == user || null == user.getUid()) {
            throw new TipException("user is null");
        }
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != 1) {
            throw new TipException("update user by uid and retrun is not one");
        }
    }
}
