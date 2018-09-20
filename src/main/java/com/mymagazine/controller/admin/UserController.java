package com.mymagazine.controller.admin;

import com.mymagazine.service.IUserService;
import com.mymagazine.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String index( ){
        userService.queryUserById(1);
        return "admin/contacts";
    }
}
