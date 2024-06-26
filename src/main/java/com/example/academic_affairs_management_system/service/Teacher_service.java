package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Teacher;

import java.util.List;

public interface Teacher_service {

    void insertTeacher(Teacher teacher);
    Teacher getTeacher(int staff_id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int staff_id);
    List<Teacher> getAllTeacher();
}
