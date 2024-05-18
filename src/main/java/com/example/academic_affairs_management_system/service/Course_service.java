package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Course;

import java.util.List;

public interface Course_service {

    void insertCourse(Course course);
    Course getCourse(String course_id);
    void updateCourse(Course course);
    void deleteCourse(String course_id);
    List<Course> getAllCourses();
}
