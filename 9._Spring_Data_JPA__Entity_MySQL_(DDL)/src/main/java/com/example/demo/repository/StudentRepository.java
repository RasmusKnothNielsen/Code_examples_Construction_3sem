package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findByName(String name);

    int countByName(String name);

    Student findStudentByName(String name);

    void deleteByName(String name);
}
