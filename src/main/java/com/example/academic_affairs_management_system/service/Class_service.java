package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Class;

import java.util.List;
import java.util.Optional;

public interface Class_service {

    void insertClass(Class clazz);
    List<Class> findClass(String semester, String courseId, Integer staffId);
    void updateClass(Class clazz);
    void deleteClass(String semester, String courseId, int staffId);
    List<Class> getAllClass();
    
}
