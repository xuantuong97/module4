package com.example.authentication.controller;

import java.security.Principal;


import com.example.authentication.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Security {

    @GetMapping(value = { "/", "/welcome" })
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcome";
    }

    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);

        return "admin_page";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {

        return "login_page";
    }

    @GetMapping(value = "/logout")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logout";
    }

    @GetMapping(value = "/user_info")
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);

        return "user_info";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

}