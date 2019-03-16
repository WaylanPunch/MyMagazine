package com.waylanpunch.mymagazine.controller.admin;

import com.waylanpunch.mymagazine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/14 23:37
 */
@Controller
@RequestMapping(value = "/admin")     // 通过这里配置使下面的映射都在 /users
public class UserController {

    @Autowired
    IUserService userService;          // 用户服务层

    /**
     *  获取用户列表
     *    处理 "/users" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @GetMapping(value = {"/user"})
    public String index(ModelMap map) {
        map.addAttribute("users", userService.findAllUsers());
        return "admin/user";
    }

}
