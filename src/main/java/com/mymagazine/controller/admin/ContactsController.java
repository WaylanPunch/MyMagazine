package com.mymagazine.controller.admin;

import com.mymagazine.bean.User;
import com.mymagazine.service.IUserService;
import com.mymagazine.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ContactsController {

    //@Autowired
    //private IUserService userService;

    @GetMapping("/contacts")
    public String index(Model model) {
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            int j = i % 16;
            user.setAvatar("/admin/demo/img/contacts/" + (j + 1) + ".jpg");
            users.add(user);
        }
        model.addAttribute("topactive", "connected");
        model.addAttribute("users", users);
        return "admin/contacts";
    }

    @GetMapping("/contacts/load")
    @ResponseBody
    public List<User> load(HttpServletRequest httpServletRequest) {
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
        return users;
    }

    @GetMapping("/contacts/recommended")
    public String recommended(Model model) {
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
        model.addAttribute("topactive", "recommended");
        model.addAttribute("users", users);
        return "admin/contacts";
    }

    @GetMapping("/contacts/requested")
    public String requested(Model model) {
        //userService.queryUserById(1);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("Nobody " + (i + 1));
            user.setEmail("nobody" + (i + 1) + "@163.com");
            user.setAvatar("/admin/demo/img/contacts/" + (i + 1) + ".jpg");
            users.add(user);
        }
        model.addAttribute("topactive", "requested");
        model.addAttribute("users", users);
        return "admin/contacts";
    }

}
