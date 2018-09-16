package com.mymagazine.controller;

import com.mymagazine.bean.RestResponse;
import com.mymagazine.bean.User;
import com.mymagazine.exception.TipException;
import com.mymagazine.service.IUserService;
import com.mymagazine.util.MagazineUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {


}
