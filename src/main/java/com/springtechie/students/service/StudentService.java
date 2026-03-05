package com.springtechie.students.service;

import com.springtechie.students.entity.Course;
import com.springtechie.students.entity.Student;
import com.springtechie.students.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

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

    public Student getStudentCourseDetailsById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()) {
            Student stu = student.get();
            ResponseEntity<Course[]> responseEntity = restTemplate.postForEntity("http://localhost:9090/course/get/courses/byIds",
                    stu.getCourseIds(), Course[].class);
            Course[] courses = responseEntity.getBody();
            stu.setCourseDetails(Arrays.stream(courses).collect(Collectors.toList()));
            return stu;
        }
        return null;

    }

    public List<Course> fetchCourses() {
        HttpEntity<String> httpEntity = new HttpEntity<>("");
        ResponseEntity<Course[]> allCourses = restTemplate.exchange("http://localhost:9090/course/allcourses", HttpMethod.GET, httpEntity, Course[].class);
        return Arrays.stream(allCourses.getBody()).collect(Collectors.toList());
    }

}


