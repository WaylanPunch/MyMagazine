package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.UserMapper;
import com.waylanpunch.mymagazine.pojo.User;
import com.waylanpunch.mymagazine.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/14 23:40
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIsNotNull();
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User findUserById(Integer userId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        if (null != users && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
