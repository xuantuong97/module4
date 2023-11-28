package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    void subtractQuantity(int bookId);
    List<Book> getAll();
    Book getBook(int id);
    void addQuantity(int booId);

}
