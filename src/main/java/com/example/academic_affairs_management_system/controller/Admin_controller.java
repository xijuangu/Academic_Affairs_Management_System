package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.pojo.Admin;
import com.example.academic_affairs_management_system.service.Admin_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class Admin_controller {

    @Autowired
    private Admin_service adminService;

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody Map<String, String> requestMap) {
        String admin_id = requestMap.get("admin_id");
        String name = requestMap.get("name");
        String password = requestMap.get("password");

        if (admin_id == null || name == null || password == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'admin_id', 'name', 'password'", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(admin_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for admin_id", HttpStatus.BAD_REQUEST);
        }

        Admin admin = new Admin();
        admin.setAdminId(ID);
        admin.setName(name);
        admin.setPassword(password);

        adminService.insertAdmin(admin);

        return new ResponseEntity<>("Admin added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{admin_id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable int admin_id) {
        Admin admin = adminService.getAdmin(admin_id);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAdmin(@RequestBody Map<String, String> requestMap) {
        String admin_id = requestMap.get("admin_id");
        if (admin_id == null) {
            return new ResponseEntity<>("Admin ID is required for update.", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(admin_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for admin_id", HttpStatus.BAD_REQUEST);
        }

        Admin existingAdmin = adminService.getAdmin(ID);
        if (existingAdmin == null) {
            return new ResponseEntity<>("Admin not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("name")) {
            existingAdmin.setName(requestMap.get("name"));
            isUpdated = true;
        }
        if (requestMap.containsKey("password")) {
            existingAdmin.setPassword(requestMap.get("password"));
            isUpdated = true;
        }

        if (isUpdated) {
            adminService.updateAdmin(existingAdmin);
            return new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{admin_id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("admin_id") String admin_id) {
        int ID;
        try {
            ID = Integer.parseInt(admin_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for admin_id", HttpStatus.BAD_REQUEST);
        }

        Admin admin = adminService.getAdmin(ID);
        if (admin == null) {
            return new ResponseEntity<>("Admin not found.", HttpStatus.NOT_FOUND);
        }

        adminService.deleteAdmin(ID);
        return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
    }

}
