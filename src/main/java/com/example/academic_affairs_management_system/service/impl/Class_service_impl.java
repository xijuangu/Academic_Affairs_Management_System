package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Class_mapper;
import com.example.academic_affairs_management_system.pojo.Class;
import com.example.academic_affairs_management_system.service.Class_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Class_service_impl implements Class_service {

    @Autowired
    private Class_mapper classMapper;

    @Override
    public void insertClass(Class clazz) {
        classMapper.insert_class(clazz);
    }

    @Override
    public List<Class> findClass(String semester, String courseId, Integer staffId) {
        return classMapper.find_classes(semester, courseId, staffId);
    }


    @Override
    public void updateClass(Class clazz) {
        classMapper.update_class(clazz);
    }

    @Override
    public void deleteClass(String semester, String courseId, int staffId) {
        classMapper.delete_class(semester, courseId, staffId);
    }

    @Override
    public List<Class> getAllClass() {
        return classMapper.get_all_class();
    }
}
