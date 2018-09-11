package com.mymagazine.controller;

import com.mymagazine.bean.User;
import com.mymagazine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService usersService;

    @GetMapping("/{uid}")
    public User selectUser(@PathVariable("uid") Integer uid) {

        return usersService.selectUserByUid(uid);
    }

    @PutMapping("/{uid}")
    public User updateUser(@PathVariable("uid") Long uid, @RequestBody User user) {
        // TODO
        return null;
    }

}
