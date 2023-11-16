package com.example.quan_ly_thu_dien_tu.model;

public class MailBox {
    private String language;
    private int pageView;
    private boolean spamFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(String language, int pageView, boolean spamFilter, String signature) {
        this.language = language;
        this.pageView = pageView;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
