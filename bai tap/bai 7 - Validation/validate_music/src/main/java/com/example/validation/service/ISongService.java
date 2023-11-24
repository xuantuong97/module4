package com.example.validation.service;


import com.example.validation.model.Song;

import java.util.List;

public interface ISongService {
   void save(Song song);
   List<Song> findAll();
   Song findById(int id);
}
