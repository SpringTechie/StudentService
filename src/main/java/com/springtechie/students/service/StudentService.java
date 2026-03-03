package com.springtechie.students.service;

import com.springtechie.students.entity.Course;
import com.springtechie.students.entity.Student;
import com.springtechie.students.repos.StudentRepository;
import org.hibernate.engine.spi.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
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

            // now we have the course ids, we need to get the course Details.
            // to get the course details based on course Ids we need to call the courseService.
            // courseService it is an external microservice, to call or interact with other MS we need to use the
            // RestTemplate object.
            return stu;
        }
        return null;

    }
///



}


