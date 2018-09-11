package com.mymagazine.controller;

import com.mymagazine.bean.User;
import com.mymagazine.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService usersService;

//    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/{uid}")
    public User selectUser(@PathVariable("uid") Integer uid) {
        return usersService.selectUserByUid(uid);
    }

//    @ApiOperation(value="更新信息", notes="根据user的id来指定更新用户信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
//            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
//    })
    @PutMapping("/{uid}")
    public User updateUser(@PathVariable("uid") Long uid, @RequestBody User user) {
        // TODO
        return null;
    }

}
