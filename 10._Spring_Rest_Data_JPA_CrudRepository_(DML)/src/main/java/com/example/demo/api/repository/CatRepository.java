package com.example.demo.api.repository;

import com.example.demo.api.model.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    Iterable<Cat> findByName(String name);
    long countByName(String name);
    Cat findCatByName(String name);
    void deleteByName(String name);

    // Example of a custom findAll() SQL query in case the CrudRepository does not contain the desired method
    @Query(value = "SELECT * FROM cat", nativeQuery = true)
    Iterable<Cat> findAllCustomQuery();

}
