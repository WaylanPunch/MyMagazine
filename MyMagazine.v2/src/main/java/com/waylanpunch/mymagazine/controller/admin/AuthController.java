package com.waylanpunch.mymagazine.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/15 0:51
 */
@Controller
@RequestMapping("/admin")
public class AuthController {


    @GetMapping(value = {"/signup"})
    public String signup() {
        //LOGGER.info("Admin Home Page");
        return "admin/login-register";
    }

    @GetMapping(value = {"/signin"})
    public String signin() {
        //LOGGER.info("Admin Home Page");
        return "admin/login-register";
    }
}
