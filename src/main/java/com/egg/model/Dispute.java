package com.egg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disputes")
public class Dispute {
    @Id
    private String disputeId;
    private Transaction transaction;
    private String reason;
    private String description;
    private String status;
    private String resolution;

    public boolean createDispute(String input) {
        return false;
    }

    public boolean updateStatus(String input) {
        return false;
    }

    public boolean resolveDispute(String input) {
        return false;
    }

    public String getDisputeStatus() {
        return null;
    }

}