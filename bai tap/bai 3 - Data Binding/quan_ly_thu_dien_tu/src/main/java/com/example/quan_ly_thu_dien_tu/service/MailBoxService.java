package com.example.quan_ly_thu_dien_tu.service;

import com.example.quan_ly_thu_dien_tu.model.MailBox;
import com.example.quan_ly_thu_dien_tu.repository.IMailBoxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService{
    @Autowired
    IMailBoxRepo iMailBoxRepo;
    @Override
    public MailBox getMailBox() {
        return iMailBoxRepo.getMailBox();
    }

    @Override
    public void updateMailBox(MailBox mailBox) {
        iMailBoxRepo.updateMailBox(mailBox);
    }

    @Override
    public List<String> getAllLanguages() {
        return iMailBoxRepo.getAllLanguages();
    }

    @Override
    public List<Integer> getAllPageSize() {
        return iMailBoxRepo.getAllPageSize();
    }
}
