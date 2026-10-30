
package com.egg.repository;

import com.egg.model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(String id);

    List<Transaction> findAll();

    void deleteById(String id);
}
