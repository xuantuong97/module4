package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showHome(){
        return "/index";
    }
    @RequestMapping("/calculator")
    public String result(@RequestParam("num1") float num1, @RequestParam("num2") float num2,
                         @RequestParam("cal") String cal, Model model){
        double result;
        switch (cal){
            case "plus": result = num1 + num2;
            break;
            case "sub": result = num1 - num2;
                break;
            case "mul": result = num1 * num2;
                break;
            default: result = num1 / num2;
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "/index";
    }
}
