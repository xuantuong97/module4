package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepo implements IDictionaryRepo{
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
