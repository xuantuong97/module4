package com.example.muon_sach.service;

import com.example.muon_sach.model.Code;

import com.example.muon_sach.repository.ICodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService implements ICodeService {
    @Autowired
    private ICodeRepo codeRepo;

    @Override
    public void save(Code code) {
        codeRepo.save(code);
    }

    @Override
    public void remove(int id) {
        codeRepo.deleteById(id);
    }

    @Override
    public String createCode() {
        int code = (int) Math.floor(((Math.random()*99999) + 10000));
        return code + "";
    }

    @Override
    public Code getCodeByCode() {
        return null;
    }
}
