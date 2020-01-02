package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@Entity
public class Student {

    @Id
    Long id;

    String name;

    @Email(message="Should be an email.")
    String email;

    @PastOrPresent
    Date DOB;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
}
