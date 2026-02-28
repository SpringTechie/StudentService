package com.springtechie.students.service;

import com.springtechie.students.entity.Student;
import com.springtechie.students.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getAllUser() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public String saveStudent(Student student) {
        studentRepository.save(student);
        return "Saved successfully";
    }

    public String deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Deleted Student of id"+ id;
        } else {
            return "Student Not found with Id" + id;
        }
    }




}


