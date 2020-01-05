package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.util.List;

@Data       // Lombok
@Entity     // JPA
@Table(name = "courses")    // JPA
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // Lad JPA bestemme (SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Brug tabellens interne auto-increment værdi, række skal først laves.
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) // Brug en 'sequence' tabel (MySQL har ikke sequence. så den bruger TABLE i stedet)
    //@GeneratedValue(strategy = GenerationType.TABLE)    // Opret tabel med numre, langsomst
    Long id;

    @NotBlank
    @Column(name = "course_description")
    String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)     // mappedBy henviser til field i Student
    List<Student> studentList;                                  // LAZY gør at studentList først hentes når den skal bruges

    @Transient  // Bruges ved åbne filer, eller ting som ikke kan genskabes på andre systemer.
    File file;


}
