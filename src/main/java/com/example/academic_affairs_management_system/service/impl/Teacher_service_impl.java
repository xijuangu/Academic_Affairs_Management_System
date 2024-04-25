package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Teacher_mapper;
import com.example.academic_affairs_management_system.pojo.Teacher;
import com.example.academic_affairs_management_system.service.Teacher_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Teacher_service_impl implements Teacher_service {

    @Autowired
    private Teacher_mapper teacherMapper;

    @Override
    public void insertTeacher(Teacher teacher) {teacherMapper.insert_teacher(teacher);}

    @Override
    public Teacher getTeacher(int staffId) {return teacherMapper.get_teacher_by_id(staffId);}

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.update_teacher(teacher);
    }

    @Override
    public void deleteTeacher(int staffId) {
        teacherMapper.delete_teacher(staffId);
    }
}
