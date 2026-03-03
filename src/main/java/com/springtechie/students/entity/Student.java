package com.springtechie.students.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<String> courseIds;
    private Integer totalCoursesEnrolled;
    private Integer completedCourses;
    private Double averageRating;
    @Transient
    private List<Course> courseDetails;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseIds=" + courseIds +
                ", totalCoursesEnrolled=" + totalCoursesEnrolled +
                ", completedCourses=" + completedCourses +
                ", averageRating=" + averageRating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Student() {

    }


    public Student(Long id, String name, String email, String phoneNumber, List<String> courseIds, Integer totalCoursesEnrolled, Integer completedCourses, Double averageRating, List<Course> courseDetails, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseIds = courseIds;
        this.totalCoursesEnrolled = totalCoursesEnrolled;
        this.completedCourses = completedCourses;
        this.averageRating = averageRating;
        this.courseDetails = courseDetails;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<Course> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<Course> courseDetails) {
        this.courseDetails = courseDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }

    public Integer getTotalCoursesEnrolled() {
        return totalCoursesEnrolled;
    }

    public void setTotalCoursesEnrolled(Integer totalCoursesEnrolled) {
        this.totalCoursesEnrolled = totalCoursesEnrolled;
    }

    public Integer getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(Integer completedCourses) {
        this.completedCourses = completedCourses;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
