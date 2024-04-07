package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.mapper.Department_mapper;
import com.example.academic_affairs_management_system.pojo.Department;
import com.example.academic_affairs_management_system.service.Department_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class Department_controller {

    @Autowired
    private Department_service department_service;
    @Autowired
    private Department_mapper department_mapper;

    @PostMapping("/add")
    public ResponseEntity<?> add_department(@RequestBody Map<String, String> requestMap)
    {
        String dept_name = requestMap.get("dept_name");
        String dept_id = requestMap.get("dept_id");
        String address = requestMap.get("address");
        String phone_code = requestMap.get("phone_code");

        if (dept_id == null || dept_name == null || address == null || phone_code == null) {
            return new ResponseEntity<>("Missing fields in request.\n" +
                    "Examine:\"dept_name\",\"dept_id\",\"address\",\"phone_code\"",
                    HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(dept_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
        }

        Department department = new Department();
        department.setDept_id(ID);
        department.setAddress(address);
        department.setDept_name(dept_name);
        department.setPhone_code(phone_code);

        department_service.insert_department(department);

        return new ResponseEntity<>("Department added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{dept_id}")
    public ResponseEntity<Department> getDepartment(@PathVariable int dept_id) {
        Department department = department_service.get_department(dept_id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }


}
