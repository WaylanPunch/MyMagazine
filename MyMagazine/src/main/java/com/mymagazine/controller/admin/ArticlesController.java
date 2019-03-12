package com.mymagazine.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/articles")
public class ArticlesController {

    @GetMapping
    public String index(Model model){
        return "admin/articles";
    }

    @GetMapping("/publish")
    public String publish(Model model){
        return "admin/publish";
    }
}
