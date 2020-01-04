package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // Lad JPA bestemme (SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Brug tabellens interne auto-increment værdi
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) // Brug en 'sequence' tabel (MySQL har ikke sequence. så den bruger TABLE i stedet)
    //@GeneratedValue(strategy = GenerationType.TABLE)    // Opret tabel med numre
    Long id;

    @NotBlank
    @Column(name = "course_description")
    String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    List<Student> studentList;

    @Transient
    File file;

    /*
    @NotNull
    @NotEmpty
    @Size(min=5, max=20)
    @Past
    @Future
    @FutureOrPresent
    @Min(5)
    @Max(10)
    @Positive
    @NegativeOrZero
    @Email
    @CreditCardNumber
     */
}
