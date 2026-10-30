
package com.egg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String transactionId;
    private String buyerId;
    private String sellerId;
    private String bookId;
    private Double amount;
    private String paymentStatus;
    private String transactionStatus;
    private Boolean refunded;

    public boolean processPayment() {
        return false;
    }

    public boolean refundPayment() {
        return false;
    }

    public boolean completeTransaction() {
        return false;
    }

    public boolean cancelTransaction() {
        return false;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }
}
