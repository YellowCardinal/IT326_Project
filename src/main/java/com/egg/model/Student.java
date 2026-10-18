package com.egg.model;

public class Student extends User {
    private String studentId;
    private String isuEmail;
    private Boolean isBanned;

    public boolean placeBookOnSale(Book book) {
        return false;
    }

    public boolean removeBookFromSale(String bookId) {
        return false;
    }

    public boolean payForBook(String bookId) {
        return false;
    }

    public boolean deleteAccount() {
        return false;
    }

}
