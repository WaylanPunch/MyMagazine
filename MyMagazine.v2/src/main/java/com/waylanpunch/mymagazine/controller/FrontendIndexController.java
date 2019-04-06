package com.waylanpunch.mymagazine.controller;

import com.waylanpunch.mymagazine.pojo.User;
import com.waylanpunch.mymagazine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/15 0:51
 */
@Controller
@RequestMapping("/magazine")
public class FrontendIndexController {

    @Autowired
    IUserService userService;          // 用户服务层

    @GetMapping(value = {"/index/{userId}"})
    public String index(ModelMap map, @PathVariable(value = "userId") Integer userId) {
        //User currentUser = (User) httpSession.getAttribute("currentUser");
        //if (null == currentUser) {
        map.addAttribute("currentUser", userService.findUserById(userId));
        //}
        return "index";
    }

    @GetMapping(value = {"/index"})
    public String currentIndex(ModelMap map, HttpSession httpSession, Integer userId) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        currentUser = new User();
        currentUser.setUserId(1);
        if (null == currentUser) {
            //map.addAttribute("currentUser", userService.findUserById(userId));
            System.out.println("No CurrentUser In Session");
        } else {
            System.out.println("CurrentUser In Session");
            map.addAttribute("currentUser", currentUser);
            return "redirect:/magazine/index/" + currentUser.getUserId();
        }
        return "error";
    }

}
