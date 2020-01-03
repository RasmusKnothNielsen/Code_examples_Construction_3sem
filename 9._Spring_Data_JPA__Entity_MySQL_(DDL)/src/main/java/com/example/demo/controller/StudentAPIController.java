package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentAPIController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }
}
