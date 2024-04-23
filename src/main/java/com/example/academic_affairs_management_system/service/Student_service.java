package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Student;

import java.util.List;

public interface Student_service {

    void insertStudent(Student student);
    Student getStudent(int student_id);
    void updateStudent(Student student);
    void deleteStudent(int student_id);
    List<Student> getAllStudent();

}
