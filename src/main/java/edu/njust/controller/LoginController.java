package edu.njust.controller;

import edu.njust.pojo.Admin;
import edu.njust.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private BackStageService service;

    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpSession session){
        int state = service.login(admin);
        if(state < 1){
            model.addAttribute("msg","账号或密码错误");
            return "sign-in";
        }else{
            session.setAttribute("curUser",admin.getUsr());
            return "redirect:/main.html";
        }
    }
}
