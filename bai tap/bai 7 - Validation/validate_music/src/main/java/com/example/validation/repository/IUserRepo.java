package com.example.validation.repository;

import com.example.validation.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<Song,Integer> {
}
