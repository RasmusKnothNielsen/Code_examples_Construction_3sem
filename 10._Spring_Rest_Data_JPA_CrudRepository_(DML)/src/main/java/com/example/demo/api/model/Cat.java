package com.example.demo.api.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Cat {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient
    private Date dt = new Date();
    @Transient
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String DOB = sdf.format(dt);

    // Default constructor
    public Cat() {
    }

    // Constructor containing all fields
    public Cat(Long id, String name, boolean spoiled, String DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    // Accessors and Mutators
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    // toString()
    public String toString() {
        return "Name: " + name + ", Date of Birth: " + DOB;
    }
}
