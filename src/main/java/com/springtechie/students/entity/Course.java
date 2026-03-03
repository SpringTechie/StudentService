package com.springtechie.students.entity;




import com.springtechie.students.constants.CourseLevel;
import com.springtechie.students.constants.CourseMode;
import com.springtechie.students.constants.CourseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;


public class Course {

    private String courseCode;
    private String courseName;
    private String description;
    @Enumerated(EnumType.STRING)
    private CourseType courseType;
    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;
    private Integer durationInHours;
    private Double fee;
    private String instructorName;
    @Enumerated(EnumType.STRING)
    private CourseMode courseMode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(Integer durationInHours) {
        this.durationInHours = durationInHours;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public CourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(CourseMode courseMode) {
        this.courseMode = courseMode;
    }

    public Course(String courseCode, String courseName, String description, CourseType courseType, CourseLevel courseLevel, Integer durationInHours, Double fee, String instructorName, CourseMode courseMode, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.courseType = courseType;
        this.courseLevel = courseLevel;
        this.durationInHours = durationInHours;
        this.fee = fee;
        this.instructorName = instructorName;
        this.courseMode = courseMode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Course() {
    }
}
