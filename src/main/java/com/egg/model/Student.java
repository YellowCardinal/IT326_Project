package com.egg.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "students")
public class Student extends User {
    @Id
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
