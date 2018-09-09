package com.mymagazine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {

        System.out.println("Home Page");
        return "index";
    }
}
