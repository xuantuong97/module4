package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepo bookRepo;
    @Override
    public void subtractQuantity(int bookId) {
        bookRepo.subtractQuantity(bookId);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public void addQuantity(int booId) {
        bookRepo.addQuantity(booId);
    }
}
