package com.mymagazine.service;

import com.mymagazine.bean.User;

import java.util.List;

public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param user 用户数据
     * @return 主键
     */

    Integer insertUser(User user);

    /**
     * 通过id查找对象
     * @param uid
     * @return
     */
    User selectUserByUid(Integer uid);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 根据主键更新user对象
     * @param user
     * @return
     */
    Integer updateUserByUid(User user);

    List<User> selectAllUsers();

    Integer deleteByUid(Integer uid);

    Long countAllUsers();
}
