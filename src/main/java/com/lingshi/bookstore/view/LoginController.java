package com.lingshi.bookstore.view;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/system")
public class LoginController {

    @RequestMapping("/login")
    public String login(String account,String password,HttpServletRequest request){
        if(account.equals("admin") && password.equals("admin")) {
            //request.getSession(true);当参数为true时与无参数的功能一致request.getSession()
            //表示系统中有会话则返回该会话，没有则创建新的会话并返回
            //request.getSession(true)；表示系统中有会话则返回该会话，没有则返回null
            //会话的有效时长时30分钟，在特定场景可调整会话的实效时长
            //会话实效有3种情况：1）.会话超时失效；2）客户端关闭；3）服务端调用session.invalidate()退出系统
            HttpSession session = request.getSession(true);//

            session.setAttribute("LOGIN_USER",account);
            return "redirect:/book/list.action";//登录成功返回列表页面
        }else {
            request.setAttribute("error","帐号或密码错误");
            return "login";//登录失败返回登录页面
        }
    }

    @RequestMapping("/login2")
    public String login2(String account,String password){
        if(account.equals("admin") && password.equals("admin")) {
            return "redirect:/book/list.action";//登录成功返回列表页面
        }else {
            return "login";//登录失败返回登录页面
        }
    }
}
