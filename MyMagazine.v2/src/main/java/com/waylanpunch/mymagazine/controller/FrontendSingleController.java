package com.waylanpunch.mymagazine.controller;

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
@RequestMapping("/magazine")
public class FrontendSingleController {


    @GetMapping(value = {"/single"})
    public String index() {
        return "single";
    }

}
