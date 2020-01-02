package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    String id;

    String description;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    List<Student> studentList;
}
