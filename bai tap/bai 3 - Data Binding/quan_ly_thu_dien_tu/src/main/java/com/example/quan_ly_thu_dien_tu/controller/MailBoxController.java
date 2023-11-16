package com.example.quan_ly_thu_dien_tu.controller;

import com.example.quan_ly_thu_dien_tu.model.MailBox;
import com.example.quan_ly_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    IMailBoxService iMailBoxService;
    
    @GetMapping("/")
    public String showInfo(Model model) {
        model.addAttribute("mailbox", iMailBoxService.getMailBox());
        return "/index";
    }

    @GetMapping("/show_update")
    public String showForm(Model model) {
        model.addAttribute("mailbox1", iMailBoxService.getMailBox());
        model.addAttribute("languages", iMailBoxService.getAllLanguages());
        model.addAttribute("pageSize", iMailBoxService.getAllPageSize());
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("mailbox1") MailBox mailBox, Model model) {
        iMailBoxService.updateMailBox(mailBox);
        model.addAttribute("mailbox", mailBox);
        return "/index";
    }
}
