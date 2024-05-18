package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Course_mapper;
import com.example.academic_affairs_management_system.pojo.Course;
import com.example.academic_affairs_management_system.service.Course_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_service_impl implements Course_service {


    @Autowired
    private Course_mapper courseMapper;

    @Override
    public void insertCourse(Course course) {
        courseMapper.insert_course(course);
    }

    @Override
    public Course getCourse(String courseId) {
        return courseMapper.get_course_by_id(courseId);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.update_course(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseMapper.delete_course(courseId);
    }

    @Override
    public List<Course> getAllCourses(){
        return courseMapper.get_all_course();
    }
}
