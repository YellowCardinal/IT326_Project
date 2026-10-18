package com.egg.model;

public class Admin extends User {
    private String adminId;

    public boolean banStudentEmail(String email) {
        return false;
    }

    public boolean deleteStudentAccount(String studentId) {
        return false;
    }

    public boolean removeBookFromStore(Book book) {
        return false;
    }

    public boolean resolveDispute(String disputeId, String action) {
        return false;
    }

}
