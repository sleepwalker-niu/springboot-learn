package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //具体的业务
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误");
            return "/login";
        }
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }
}
