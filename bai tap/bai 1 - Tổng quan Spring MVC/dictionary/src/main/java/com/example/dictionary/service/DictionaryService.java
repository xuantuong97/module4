package com.example.dictionary.service;

import com.example.dictionary.repository.IDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepo dictionaryRepo;
    @Override
    public Map<String, String> getAll() {
        return dictionaryRepo.getAll();
    }
}
