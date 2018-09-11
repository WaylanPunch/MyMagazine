package com.mymagazine.service.impl;

import com.mymagazine.bean.User;
import com.mymagazine.dao.UserMapper;
import com.mymagazine.exception.TipException;
import com.mymagazine.service.IUserService;
import com.mymagazine.util.MagazineUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        Integer uid = null;
        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())) {
            // 用户密码加密
            String encodePwd = MagazineUtil.MD5encode(user.getPassword());
            user.setPassword(encodePwd);
            userMapper.insertUser(user);
        }
        return user.getUid();
    }

    @Override
    public User selectUserByUid(Integer uid) {
        User user = null;
        if (uid != null) {
            user = userMapper.selectUserByUid(uid);
        }
        return user;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new TipException("Username or Password is empty");
        }

        int count = userMapper.checkUserIfExists(username);
        if (count < 1) {
            throw new TipException("User does not exist");
        }

        String pwd = MagazineUtil.MD5encode(password);
        User user = userMapper.selectUserByUserAndPassword(username, pwd);
        if (null == user) {
            throw new TipException("Username or Password is wrong");
        }
        return user;
    }

    @Override
    public Integer updateUserByUid(User user) {
        if (null == user || null == user.getUid()) {
            throw new TipException("user is null");
        }
        String pwd = MagazineUtil.MD5encode(user.getPassword());
        user.setPassword(pwd);
        int i = userMapper.updateUserByUid(user);
        if (i != 1) {
            throw new TipException("update user by uid and retrun is not one");
        }
        return i;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = userMapper.selectAllUsers();
        if (users == null || users.size() < 1) {
            throw new TipException("there is no user in the database");
        }
        return users;
    }

    @Override
    public Integer deleteByUid(Integer uid) {
        int i = userMapper.deleteByUid(uid);
        if (i != 1) {
            throw new TipException("delete user by uid and retrun is not one");
        }
        return i;
    }

    @Override
    public Long countAllUsers() {
        return userMapper.count();
    }
}
