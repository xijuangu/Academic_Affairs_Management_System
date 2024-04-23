package com.example.academic_affairs_management_system.controller;


import com.example.academic_affairs_management_system.pojo.Student;
import com.example.academic_affairs_management_system.service.Student_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class Student_controller {

    @Autowired
    private Student_service studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Map<String, String> requestMap) {
        String student_id = requestMap.get("student_id");
        String name = requestMap.get("name");
        String sex = requestMap.get("sex");
        String date_of_birth = requestMap.get("date_of_birth");
        String native_place = requestMap.get("native_place");
        String mobile_phone = requestMap.get("mobile_phone");
        String dept_id = requestMap.get("dept_id");
        String status = requestMap.get("status");
        String password = requestMap.get("password");

        if (student_id == null || name == null || sex == null || date_of_birth == null || native_place == null || mobile_phone == null || dept_id == null || status == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'student_id', 'name', 'sex', 'date_of_birth', 'native_place', 'mobile_phone', 'dept_id', 'status', 'password'", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(student_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for student_id", HttpStatus.BAD_REQUEST);
        }

        Student student = new Student();
        student.setStudentId(ID);
        student.setName(name);
        student.setSex(sex.charAt(0));
        student.setDateOfBirth(java.sql.Date.valueOf(date_of_birth));
        student.setNativePlace(native_place);
        student.setMobilePhone(mobile_phone);
        student.setDepartment(Integer.parseInt(dept_id));
        student.setStatus(status);
        student.setPassword(password);

        studentService.insertStudent(student);

        return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{student_id}")
    public ResponseEntity<Student> getStudent(@PathVariable int student_id) {
        Student student = studentService.getStudent(student_id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Map<String, String> requestMap) {
        String student_id = requestMap.get("student_id");
        if (student_id == null) {
            return new ResponseEntity<>("Student ID is required for update.", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(student_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for student_id", HttpStatus.BAD_REQUEST);
        }

        Student existingStudent = studentService.getStudent(ID);
        if (existingStudent == null) {
            return new ResponseEntity<>("Student not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("name")) {
            existingStudent.setName(requestMap.get("name"));
            isUpdated = true;
        }
        if (requestMap.containsKey("sex") && requestMap.get("sex").length() == 1) {
            existingStudent.setSex(requestMap.get("sex").charAt(0));
            isUpdated = true;
        }
        if (requestMap.containsKey("date_of_birth")) {
            try {
                existingStudent.setDateOfBirth(java.sql.Date.valueOf(requestMap.get("date_of_birth")));
                isUpdated = true;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>("Invalid format for date_of_birth", HttpStatus.BAD_REQUEST);
            }
        }
        if (requestMap.containsKey("native_place")) {
            existingStudent.setNativePlace(requestMap.get("native_place"));
            isUpdated = true;
        }
        if (requestMap.containsKey("mobile_phone")) {
            existingStudent.setMobilePhone(requestMap.get("mobile_phone"));
            isUpdated = true;
        }
        if (requestMap.containsKey("dept_id")) {
            try {
                existingStudent.setDepartment(Integer.parseInt(requestMap.get("dept_id")));
                isUpdated = true;
            } catch (NumberFormatException e) {
                return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
            }
        }
        if (requestMap.containsKey("status")) {
            existingStudent.setStatus(requestMap.get("status"));
            isUpdated = true;
        }
        if (requestMap.containsKey("password")) {
            existingStudent.setPassword(requestMap.get("password"));
            isUpdated = true;
        }

        if (isUpdated) {
            studentService.updateStudent(existingStudent);
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("student_id") String student_id) {
        int ID;
        try {
            ID = Integer.parseInt(student_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for student_id", HttpStatus.BAD_REQUEST);
        }

        Student student = studentService.getStudent(ID);
        if (student == null) {
            return new ResponseEntity<>("Student not found.", HttpStatus.NOT_FOUND);
        }

        studentService.deleteStudent(ID);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

}

