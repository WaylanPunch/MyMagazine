package com.mymagazine.controller.admin;

import com.mymagazine.bean.Log;
import com.mymagazine.bean.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/logs")
public class LogsController {

    @GetMapping
    public String index(Model model) {
        return "admin/logs";
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseResult list(HttpServletRequest httpServletRequest) {
        String count = httpServletRequest.getParameter("count");
        String size = httpServletRequest.getParameter("size");
        System.out.println(count);
        System.out.println(size);
        List<Log> logs = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("logs", logs);
        ResponseResult responseResult = new ResponseResult(200, "OK", map);
        return responseResult;
    }
}
