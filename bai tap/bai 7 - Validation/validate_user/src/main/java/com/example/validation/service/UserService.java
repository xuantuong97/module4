package com.example.validation.service;

import com.example.validation.model.User;
import com.example.validation.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo userRepo;
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
