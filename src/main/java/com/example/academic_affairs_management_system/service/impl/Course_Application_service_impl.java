package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Course_Application_mapper;
import com.example.academic_affairs_management_system.pojo.CourseApp;
import com.example.academic_affairs_management_system.service.Course_Application_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Course_Application_service_impl implements Course_Application_service {
    @Autowired
    private Course_Application_mapper courseApplicationMapper;

    @Override
    public void insertCourseApplication(CourseApp courseapp) {
        courseApplicationMapper.insert_course_application(courseapp);
    }

    @Override
    public CourseApp getCourseApplication(int courseApplicationId) {
        return courseApplicationMapper.get_course_application_by_id(courseApplicationId);
    }

    @Override
    public void updateCourseApplication(CourseApp courseapp) {
        courseApplicationMapper.update_course_application(courseapp);
    }

    @Override
    public void deleteCourseApplication(int courseApplicationId) {
        courseApplicationMapper.delete_course_application(courseApplicationId);
    }
}
