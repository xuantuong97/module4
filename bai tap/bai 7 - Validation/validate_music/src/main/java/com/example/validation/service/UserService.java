package com.example.validation.service;

import com.example.validation.model.Song;
import com.example.validation.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo userRepo;
    @Override
    public void saveUser(Song song) {
        userRepo.save(song);
    }
}
