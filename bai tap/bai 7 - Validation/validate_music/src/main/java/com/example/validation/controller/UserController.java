package com.example.validation.controller;

import com.example.validation.model.Song;
import com.example.validation.model.SongDto;
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
        model.addAttribute("userDto", new SongDto());
        return "/sign_in";
    }
    @PostMapping("/register")
    public String register(@Valid SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        Song song = new Song();
        new SongDto().validate(songDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/sign_in";
        }
        BeanUtils.copyProperties(songDto, song);
        userService.saveUser(song);
        return "/result";
    }
}
