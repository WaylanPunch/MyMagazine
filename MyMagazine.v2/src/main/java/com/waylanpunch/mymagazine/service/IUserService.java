package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    User findUserById(Integer userId);
}
