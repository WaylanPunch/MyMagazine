package com.waylanpunch.mymagazine.controller.admin;

import com.waylanpunch.mymagazine.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/admin")
public class LogController {

    @Autowired
    private ILogService logService;

    @GetMapping(value = {"/log"})
    public String index(ModelMap map) {
        map.addAttribute("logs", logService.findAllLogs());
        return "admin/log";
    }

}
