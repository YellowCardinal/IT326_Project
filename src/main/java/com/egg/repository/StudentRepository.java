package com.egg.repository;

import com.egg.model.Student;
import java.util.List;
import java.util.Optional;

/** Data access operations for student documents in the students collection. */
public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(String id);

    List<Student> findAll();

    void deleteById(String id);
}
