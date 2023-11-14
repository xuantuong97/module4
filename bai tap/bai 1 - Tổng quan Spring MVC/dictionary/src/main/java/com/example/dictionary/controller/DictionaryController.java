package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String showForm(){
        return "/dictionary";
    }
    @PostMapping("/dictionary")
    public String result(@RequestParam String input, Model model){
        String result;
        result = dictionaryService.getAll().get(input.trim().toLowerCase());
        if(result==null){
            result = "Not found";
        }
        model.addAttribute("result", result);
        return "/dictionary";
    }
}
