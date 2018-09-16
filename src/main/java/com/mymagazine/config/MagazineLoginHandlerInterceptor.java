package com.mymagazine.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MagazineLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String login_email = (String) request.getSession().getAttribute("LOGIN_email");
//        if (StringUtils.isEmpty(login_email)) {
//            request.setAttribute("msg", "hasn't sign in yet");
//            request.getRequestDispatcher("/admin/login").forward(request, response);
//            return false;
//        } else {
//            return true;
//        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
