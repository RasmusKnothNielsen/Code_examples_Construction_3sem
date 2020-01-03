package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CourseAPIController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/course")
    public Iterable<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/course")
    public Course postCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
}
