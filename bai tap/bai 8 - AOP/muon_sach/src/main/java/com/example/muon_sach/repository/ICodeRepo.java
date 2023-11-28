package com.example.muon_sach.repository;


import com.example.muon_sach.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICodeRepo extends JpaRepository<Code, Integer> {
    @Query("SELECT b FROM Code b WHERE b.code = :code")
    Code findByCode(@Param("code") int code);
}
