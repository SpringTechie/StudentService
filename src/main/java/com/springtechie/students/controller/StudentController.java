package com.springtechie.students.controller;

import com.springtechie.students.entity.Student;
import com.springtechie.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    // Admin Role -> security
    @GetMapping("/get/all")
    public List<Student> getStudents() {
        return studentService.getAllUser();
    }

    //
    @GetMapping("/get/id/{id}")
    public Student fetchStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    // student creates it data
    @PostMapping("/save")
    public String createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // student and admin
    @DeleteMapping("/delete/id/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/get/studentcourse/details/id/{id}")
    public Student getStudentCourseDetailsById(@PathVariable int id) {
        return studentService.getStudentCourseDetailsById(id);
    }


}
