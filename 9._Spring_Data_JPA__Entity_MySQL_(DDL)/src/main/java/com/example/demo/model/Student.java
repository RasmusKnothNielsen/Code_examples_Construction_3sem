package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    // @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.ORDINAL)
    Gender gender;

    @Email(message = "Should be an email.")
    String email;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

}
