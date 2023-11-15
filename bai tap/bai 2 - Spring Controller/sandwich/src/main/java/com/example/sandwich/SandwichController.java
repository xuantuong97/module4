package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public  String showHome(){
        return "/index";
    }

    @RequestMapping("/condiment")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "/detail";
    }
}
