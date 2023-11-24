package com.example.validation.controller;

import com.example.validation.model.User;
import com.example.validation.model.UserDto;
import com.example.validation.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/sign_in";
    }
    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/sign_in";
        }
        BeanUtils.copyProperties(userDto, user);
        userService.saveUser(user);
        return "/result";
    }
}
