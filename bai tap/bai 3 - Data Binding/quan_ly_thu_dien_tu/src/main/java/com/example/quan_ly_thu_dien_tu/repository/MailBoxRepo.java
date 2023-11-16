package com.example.quan_ly_thu_dien_tu.repository;

import com.example.quan_ly_thu_dien_tu.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepo implements IMailBoxRepo {

    private static List<String> languages = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    private static List<Integer> pageSize = new ArrayList<>();

    static {
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
    }

    MailBox mailBox = new MailBox("English", 30, false, "Tuong");

    @Override
    public MailBox getMailBox() {
        return mailBox;
    }

    @Override
    public void updateMailBox(MailBox mailBox1) {
        mailBox = mailBox1;
    }

    @Override
    public List<String> getAllLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getAllPageSize() {
        return pageSize;
    }
}
