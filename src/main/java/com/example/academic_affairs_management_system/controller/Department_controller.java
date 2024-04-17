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


    @PostMapping("/update")
    public ResponseEntity<?> update_department(@RequestBody Map<String, String> requestMap) {
        String dept_id = requestMap.get("dept_id");
        if (dept_id == null) {
            return new ResponseEntity<>("Department ID is required for update.", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(dept_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
        }

        Department existingDepartment = department_service.get_department(ID);
        if (existingDepartment == null) {
            return new ResponseEntity<>("Department not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("dept_name")) {
            existingDepartment.setDept_name(requestMap.get("dept_name"));
            isUpdated = true;
        }
        if (requestMap.containsKey("address")) {
            existingDepartment.setAddress(requestMap.get("address"));
            isUpdated = true;
        }
        if (requestMap.containsKey("phone_code")) {
            existingDepartment.setPhone_code(requestMap.get("phone_code"));
            isUpdated = true;
        }

        if (isUpdated) {
            department_service.update_department(existingDepartment);
            return new ResponseEntity<>("Department updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{dept_id}")
    public ResponseEntity<?> delete_department(@PathVariable("dept_id") String dept_id) {
        int ID;
        try {
            ID = Integer.parseInt(dept_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
        }

        Department department = department_service.get_department(ID);
        if (department == null) {
            return new ResponseEntity<>("Department not found.", HttpStatus.NOT_FOUND);
        }

        department_service.delete_department(ID);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }


}
