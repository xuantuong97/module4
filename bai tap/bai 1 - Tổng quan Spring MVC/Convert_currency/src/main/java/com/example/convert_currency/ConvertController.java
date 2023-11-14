package com.example.convert_currency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String showForm(){
        return "/convert";
    }
    @PostMapping("/convert")
    public String result(@RequestParam double input, Model model){
        double result = input * 24000;
        model.addAttribute("result",result);
        return "/convert";
    }
}


