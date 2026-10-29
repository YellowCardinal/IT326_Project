package com.egg.repository;

import com.egg.model.Admin;

import java.util.List;
import java.util.Optional;

/** Data access operations for admin documents. */
public interface AdminRepository {

    Admin save(Admin admin);

    Optional<Admin> findById(String id);

    List<Admin> findAll();

    void deleteById(String id);
}
