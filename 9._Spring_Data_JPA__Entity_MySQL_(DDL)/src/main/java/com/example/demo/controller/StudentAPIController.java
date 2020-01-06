package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/student/{name}")
    public Student getStudent(@PathVariable String name) {
        return studentRepository.findStudentByName(name);
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    // PUT request to change a student in the database
    @PutMapping("/student/{name}")
    public String updateStudent(@PathVariable String name, @RequestBody Student student) {
        // use the Crudrepository to update a student in the student table
        Iterable<Student> foundStudent = studentRepository.findByName(name);
        if (foundStudent != null) {
            if (studentRepository.countByName(name) < 1) {
                return "No student named: " + name + " in table student";
            } else if (studentRepository.countByName(name) > 1) {
                return "More than one Student named: " + name + " in table student, please request by Id instead of name";
            } else {
                Student newStudent = studentRepository.findStudentByName(name);
                newStudent.setName(student.getName());
                newStudent.setEmail(student.getEmail());
                newStudent.setDob(student.getDob());
                newStudent.setGender(student.getGender());
                newStudent.setCourse(student.getCourse());
                studentRepository.save(newStudent);
                return "Student updated";
            }
        } else {
            return "Student not found";
        }
    }

    // DELETE request removing a student from the database
    @Transactional
    @DeleteMapping("/student/{name}")
    public String deleteStudentFromDB(@PathVariable String name) {
        Iterable<Student> foundStudent = studentRepository.findByName(name);
        if (foundStudent != null) {
            if (studentRepository.countByName(name) < 1) {
                return "No student named: " + name + " in table student";
            } else if (studentRepository.countByName(name) > 1) {
                return "More than one student named: " + name + " in table student, please request by Id instead of name";
            } else {
                studentRepository.deleteByName(name);
                return "Student deleted";
            }
        } else {
            return "Student not found";
        }
    }
}
