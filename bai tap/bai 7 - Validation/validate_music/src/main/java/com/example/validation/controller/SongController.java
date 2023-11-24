package com.example.validation.controller;

import com.example.validation.model.Song;
import com.example.validation.model.SongDto;
import com.example.validation.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songs",songService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showAddForm(Model model){
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }
    @PostMapping("/create")
    public String addNewSong(@Valid SongDto songDto, BindingResult bindingResult){
        Song song = new Song();
        new SongDto().validate(songDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song";
    }
}
