package com.example.quan_ly_thu_dien_tu.repository;

import com.example.quan_ly_thu_dien_tu.model.MailBox;

import java.util.List;

public interface IMailBoxRepo {
    MailBox getMailBox();
    void updateMailBox(MailBox mailBox);
    List<String> getAllLanguages();
    List<Integer> getAllPageSize();
}
