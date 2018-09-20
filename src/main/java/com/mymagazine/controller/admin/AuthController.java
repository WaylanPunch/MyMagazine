package com.mymagazine.controller.admin;

import com.mymagazine.bean.ResponseResult;
import com.mymagazine.bean.User;
import com.mymagazine.exception.TipException;
import com.mymagazine.service.IUserService;
import com.mymagazine.util.MagazineConstant;
import com.mymagazine.util.MagazineUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AuthController {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private IUserService usersService;

    //    @Resource
//    private ILogService logService;

    @GetMapping
    public String index() {
        LOGGER.info("Admin Home Page");
        return "admin/index";
    }

    @GetMapping(value = {"/login"})
    public String login() {
        LOGGER.info("Admin Login Page");
        return "admin/login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param rememberme
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/signin")
    @ResponseBody
    public ResponseResult signin(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam(value = "rememberme", required = false) String rememberme,
                                 org.apache.catalina.servlet4preview.http.HttpServletRequest request,
                                 HttpServletResponse response) {

        String msg = "";
        //Integer error_count = cache.get("login_error_count");
        try {
            User user = usersService.login(username, password);
            request.getSession().setAttribute(MagazineConstant.LOGIN_SESSION_KEY, user);
            if (!StringUtils.isEmpty(rememberme)) {
                MagazineUtil.setCookie(response, user.getUid());
            }
            msg = "登录成功";
            //logService.insertLog(LogActions.LOGIN.getAction(), null, request.getRemoteAddr(), user.getUid());
        } catch (Exception e) {
//            error_count = null == error_count ? 1 : error_count + 1;
//            if (error_count > 3) {
//                return RestResponse.fail("您输入密码已经错误超过3次，请10分钟后尝试");
//            }
            //cache.set("login_error_count", error_count, 10 * 60);
            msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return new ResponseResult(401, msg, null);
        }
        return new ResponseResult(200, msg, null);
    }

    /**
     * 注销
     *
     * @param session
     * @param response
     * @param request
     */
    @RequestMapping("/signout")
    public void signout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.removeAttribute(MagazineConstant.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(MagazineConstant.LOGIN_COOKIE_KEY, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);// 立即销毁cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            response.sendRedirect("/admin/login");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("注销失败", e);
        }
    }

}
