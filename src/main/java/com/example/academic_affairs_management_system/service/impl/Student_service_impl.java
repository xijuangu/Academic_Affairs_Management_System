package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Student_mapper;
import com.example.academic_affairs_management_system.pojo.Student;
import com.example.academic_affairs_management_system.service.Student_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_service_impl implements Student_service {

    @Autowired
    private Student_mapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.insert_student(student);
    }

    @Override
    public Student getStudent(int studentId) {
        return studentMapper.get_student_by_id(studentId);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update_student(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentMapper.delete_student(studentId);
    }

    @Override
    public List<Student> getAllStudent(){ return studentMapper.get_all_student(); }
}
