package com.mymagazine.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AuthController {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping(value = {"/", "/index","/index.html"})
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Admin Home Page");
        return "admin/index";
    }

    @GetMapping(value = {"/", "/login","/login.html"})
    public String login(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Admin Login Page");
        return "admin/login";
    }

}
