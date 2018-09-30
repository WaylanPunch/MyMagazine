package com.mymagazine.controller.admin;

import com.mymagazine.bean.ResponseResult;
import com.mymagazine.bean.User;
import com.mymagazine.service.IUserService;
import com.mymagazine.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ContactsController {

    //@Autowired
    //private IUserService userService;

    @GetMapping("/contacts")
    public String index(Model model) {
        //userService.queryUserById(1);
        /*
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            int j = i % 16;
            user.setAvatar("/admin/demo/img/contacts/" + (j + 1) + ".jpg");
            users.add(user);
        }
        model.addAttribute("contacts_active", "connected");
        model.addAttribute("users", users);
        */
        return "admin/contacts";
    }

    @GetMapping("/contacts/connected")
    @ResponseBody
    public ResponseResult connected(HttpServletRequest httpServletRequest) {
        String count = httpServletRequest.getParameter("count");
        String size = httpServletRequest.getParameter("size");
        System.out.println(count);
        System.out.println(size);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            int j = i % 16;
            user.setAvatar("/admin/demo/img/contacts/" + (j + 1) + ".jpg");
            users.add(user);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("contacts_active", "connected");
        map.put("users", users);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
//        model.addAttribute("contacts_active", "connected");
//        model.addAttribute("users", users);
        return responseResult;
    }

    @GetMapping("/contacts/load")
    @ResponseBody
    public ResponseResult load(HttpServletRequest httpServletRequest) {
        String count = httpServletRequest.getParameter("count");
        String size = httpServletRequest.getParameter("size");
        System.out.println(count);
        System.out.println(size);
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
        //model.addAttribute("moreusers", users);
        Map<String, Object> map = new HashMap<>();
        //map.put("contacts_active", "connected");
        map.put("users", users);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
//        model.addAttribute("contacts_active", "connected");
//        model.addAttribute("users", users);
        return responseResult;
    }

    @GetMapping("/contacts/recommended")
    @ResponseBody
    public ResponseResult recommended(Model model) {
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
//        model.addAttribute("contacts_active", "recommended");
//        model.addAttribute("users", users);
        Map<String, Object> map = new HashMap<>();
        map.put("contacts_active", "recommended");
        map.put("users", users);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
        return responseResult;
    }

    @GetMapping("/contacts/refresh")
    @ResponseBody
    public ResponseResult refresh(HttpServletRequest httpServletRequest) {
        String count = httpServletRequest.getParameter("count");
        String size = httpServletRequest.getParameter("size");
        System.out.println(count);
        System.out.println(size);
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
        //model.addAttribute("moreusers", users);
        Map<String, Object> map = new HashMap<>();
        //map.put("contacts_active", "connected");
        map.put("users", users);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
//        model.addAttribute("contacts_active", "connected");
//        model.addAttribute("users", users);
        return responseResult;
    }

    @GetMapping("/contacts/requested")
    @ResponseBody
    public ResponseResult requested(Model model) {
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
//        model.addAttribute("contacts_active", "requested");
//        model.addAttribute("users", users);
        Map<String, Object> map = new HashMap<>();
        map.put("contacts_active", "requested");
        map.put("users", users);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
        return responseResult;
    }

}
