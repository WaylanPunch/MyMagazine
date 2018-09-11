package com.mymagazine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping(value = "/")
    public String home(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Home Page");
        return "index";
    }

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Home Page");
        return "index";
    }

    @GetMapping(value = "/single")
    public String single(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Single Page");
        return "single";
    }
}
