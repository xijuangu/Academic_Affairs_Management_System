package com.example.academic_affairs_management_system.controller;


import com.example.academic_affairs_management_system.pojo.Student;
import com.example.academic_affairs_management_system.pojo.Teacher;
import com.example.academic_affairs_management_system.service.Teacher_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class Teacher_controller {

    @Autowired
    private Teacher_service teacherService;

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody Map<String, String> requestMap) {
        String staff_id = requestMap.get("staff_id");
        String name = requestMap.get("name");
        String sex = requestMap.get("sex");
        String date_of_birth = requestMap.get("date_of_birth");
        String professional_ranks = requestMap.get("professional_ranks");
        String salary = requestMap.get("salary");
        String dept_id = requestMap.get("dept_id");
        String password = requestMap.get("password");


        if (staff_id == null || name == null || sex == null || date_of_birth == null || professional_ranks == null || salary == null || dept_id == null || password == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'student_id', 'name', 'sex', 'date_of_birth', 'professional_ranks', 'salary', 'dept_id', 'password'", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(staff_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for staff_id", HttpStatus.BAD_REQUEST);
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(ID);
        teacher.setName(name);
        teacher.setSex(sex.charAt(0));
        teacher.setDateOfBirth(java.sql.Date.valueOf(date_of_birth));
        teacher.setProfessionalRanks(professional_ranks);
        teacher.setSalary(salary);
        teacher.setDepartment(Integer.parseInt(dept_id));
        teacher.setPassword(password);


        teacherService.insertTeacher(teacher);

        return new ResponseEntity<>("Teacher added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{staff_id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int staff_id) {
        Teacher teacher = teacherService.getTeacher(staff_id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateTeacher(@RequestBody Map<String, String> requestMap) {
        String staff_id = requestMap.get("staff_id");
        if (staff_id == null) {
            return new ResponseEntity<>("Teacher ID is required for update.", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(staff_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for staff_id", HttpStatus.BAD_REQUEST);
        }

        Teacher existingTeacher = teacherService.getTeacher(ID);
        if (existingTeacher == null) {
            return new ResponseEntity<>("Teacher not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("name")) {
            existingTeacher.setName(requestMap.get("name"));
            isUpdated = true;
        }
        if (requestMap.containsKey("sex") && requestMap.get("sex").length() == 1) {
            existingTeacher.setSex(requestMap.get("sex").charAt(0));
            isUpdated = true;
        }
        if (requestMap.containsKey("date_of_birth")) {
            try {
                existingTeacher.setDateOfBirth(java.sql.Date.valueOf(requestMap.get("date_of_birth")));
                isUpdated = true;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>("Invalid format for date_of_birth", HttpStatus.BAD_REQUEST);
            }
        }
        if (requestMap.containsKey("professional_ranks")) {
            existingTeacher.setProfessionalRanks(requestMap.get("professional_ranks"));
            isUpdated = true;
        }
        if (requestMap.containsKey("salary")) {
            existingTeacher.setSalary(requestMap.get("salary"));
            isUpdated = true;
        }
        if (requestMap.containsKey("dept_id")) {
            try {
                existingTeacher.setDepartment(Integer.parseInt(requestMap.get("dept_id")));
                isUpdated = true;
            } catch (NumberFormatException e) {
                return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
            }
        }
        if (requestMap.containsKey("password")) {
            try {
                existingTeacher.setPassword(requestMap.get("password"));
                isUpdated = true;
            } catch (NumberFormatException e) {
                return new ResponseEntity<>("Invalid format for password", HttpStatus.BAD_REQUEST);
            }
        }

        if (isUpdated) {
            teacherService.updateTeacher(existingTeacher);
            return new ResponseEntity<>("Teacher updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{staff_id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("staff_id") String staff_id) {
        int ID;
        try {
            ID = Integer.parseInt(staff_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for staff_id", HttpStatus.BAD_REQUEST);
        }

        Teacher teacher = teacherService.getTeacher(ID);
        if (teacher == null) {
            return new ResponseEntity<>("Teacher not found.", HttpStatus.NOT_FOUND);
        }

        teacherService.deleteTeacher(ID);
        return new ResponseEntity<>("Teacher deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllTeacher")
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);
    }

}
