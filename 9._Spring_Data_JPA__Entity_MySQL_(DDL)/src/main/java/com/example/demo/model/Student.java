package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data       // Lombok
@Entity     // JPA
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull // Validation. Bliver også brugt i databasen (NOT NULL)
    // @Column(nullable = false) // Bliver kun brugt i databasen (NOT NULL)
    String name;

    @Enumerated(EnumType.STRING)
    // @Enumerated(EnumType.ORDINAL)
    Gender gender;

    @Email(message = "Should be an email.")
    String email;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    /*
    @NotEmpty
    @Size(min=5, max=20)
    @Past
    @Future
    @FutureOrPresent
    @Min(5)
    @Max(10)
    @Positive
    @NegativeOrZero
    @CreditCardNumber
     */
}
