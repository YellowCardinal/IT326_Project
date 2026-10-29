package com.egg.repository;

import com.egg.model.Dispute;
import java.util.List;
import java.util.Optional;

/** Data access operations for dispute documents in the disputes collection. */
public interface DisputeRepository {

    Dispute save(Dispute dispute);

    Optional<Dispute> findById(String id);

    List<Dispute> findAll();

    void deleteById(String id);
}