package com.lingshi.bookstore.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    //在拦截点执行前执行，如果返回false则不执行拦截点后的操作，true则不拦截
        HttpSession session = httpServletRequest.getSession();
        String url = httpServletRequest.getRequestURI();
        if(session.getAttribute("LOGIN_USER") != null
               /* || url.indexOf("system/login.action")>0*/){ //说明登录成功
           return true;
        }else {
            //拦截后进入登录页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/pages/login.jsp");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//    在处理过程中，执行拦截
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        执行完毕，返回前拦截
    }
}
