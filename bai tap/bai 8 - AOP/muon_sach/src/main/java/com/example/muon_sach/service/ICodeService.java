package com.example.muon_sach.service;

import com.example.muon_sach.model.Code;

public interface ICodeService {
    void save (Code code);
    void remove (int id);
    String createCode();
    Code getCodeByCode();
}
