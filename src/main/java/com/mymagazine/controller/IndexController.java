package com.mymagazine.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

//    @ApiOperation(value="站点首页", notes="站点首页")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/")
    public String home(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Home Page");
        return "index";
    }

//    @ApiOperation(value="站点首页", notes="站点首页")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Home Page");
        return "index";
    }

//    @ApiOperation(value="文章页面", notes="文章页面")
//    @ApiImplicitParam(name = "limit", value = "不不不", required = false, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/single")
    public String single(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        LOGGER.info("Single Page");
        return "single";
    }
}
