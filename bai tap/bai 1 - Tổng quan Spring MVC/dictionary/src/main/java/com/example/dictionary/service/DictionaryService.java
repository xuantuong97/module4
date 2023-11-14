package com.example.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService{
    private static Map<String, String> dictionary = new HashMap<String, String>();
    static {
        dictionary.put("banana","Chuối");
        dictionary.put("apple","Táo");
        dictionary.put("orange","Cam");
        dictionary.put("avocado","Bơ");
    }
    @Override
    public Map<String, String> getAll() {
        return dictionary;
    }
}
