package com.example.validation.service;

import com.example.validation.model.Song;
import com.example.validation.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepo songRepo;

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepo.findById(id).get();
    }
}
