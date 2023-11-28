package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.Code;
import com.example.muon_sach.service.IBookService;
import com.example.muon_sach.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ICodeService codeService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("books", bookService.getAll());
        return "/list";
    }
    @GetMapping("/detail{id}")
    public String showDetail(Model model, @PathVariable int id){
        model.addAttribute("book", bookService.getBook(id));
        return "/detail";
    }
    @GetMapping("/borrow{id}")
    public String borrowBook(Model model,@PathVariable int id){
        String randomCode = codeService.createCode();
        Book book = bookService.getBook(id);
        bookService.subtractQuantity(id);
        Code code = new Code();
        code.setCode(randomCode);
        code.setBook(book);
        codeService.save(code);

        model.addAttribute("yourCode", randomCode);
        return "your_code";
    }
}
