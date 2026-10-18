package com.egg.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "admins")
public class Admin extends User {
    @Id
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
