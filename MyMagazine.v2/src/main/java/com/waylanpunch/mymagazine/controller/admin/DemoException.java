package com.waylanpunch.mymagazine.controller.admin;

import com.waylanpunch.mymagazine.util.MagazineException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/4/6 15:14
 */
@RestController
@RequestMapping("/error")
public class DemoException {

    @GetMapping(value = "/custome")
    public void customException() {
        throw new MagazineException(100, "这个是自定义异常！");
    }

    @GetMapping(value = "/unknown")
    public void unknownException() {
        int i = 0;
        int b = 1 / i;
    }
}