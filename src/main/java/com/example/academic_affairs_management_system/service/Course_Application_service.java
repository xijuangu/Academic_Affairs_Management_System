package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.CourseApp;
import org.springframework.stereotype.Service;

public interface Course_Application_service {

    void insertCourseApplication(CourseApp courseapp);
    CourseApp getCourseApplication(int course_application_id);
    void updateCourseApplication(CourseApp courseapp);
    void deleteCourseApplication(int course_application_id);

}
