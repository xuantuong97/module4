package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Controller
public class DictionaryController {
    private static Map<String, String> dictionary = new HashMap<String, String>();
    static {
        dictionary.put("banana","Chuối");
        dictionary.put("apple","Táo");
        dictionary.put("orange","Cam");
        dictionary.put("avocado","Bơ");
    }
    @GetMapping("/dictionary")
    public String showForm(){
        return "/dictionary";
    }
    @PostMapping("/dictionary")
    public String result(@RequestParam String input, Model model){
        String result;
        result = dictionary.get(input.trim().toLowerCase());
        if(result==null){
            result = "Not found";
        }
        model.addAttribute("result", result);
        return "/dictionary";
    }
}
