package com.example.muon_sach.repository;

import com.example.muon_sach.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepo extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Book p SET p.quantity = p.quantity - 1 WHERE p.bookId = :bookId")
    void subtractQuantity(@Param("bookId") int bookId);

    @Transactional
    @Modifying
    @Query("UPDATE Book p SET p.quantity = p.quantity + 1 WHERE p.bookId = :bookId")
    void addQuantity(@Param("bookId") int bookId);
}
