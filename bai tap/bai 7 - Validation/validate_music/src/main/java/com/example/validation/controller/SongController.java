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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam int id){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "/edit";
    }
    @PostMapping("/edit")
    public String editSong(@Valid RedirectAttributes redirectAttributes, Song song, BindingResult bindingResult){
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        songService.save(song);
        return "redirect:/list";
    }
}
