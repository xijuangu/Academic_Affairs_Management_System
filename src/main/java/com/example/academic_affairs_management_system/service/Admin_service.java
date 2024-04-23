package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Admin;

import java.util.List;

public interface Admin_service {

    void insertAdmin(Admin admin);
    Admin getAdmin(int admin_id);
    void updateAdmin(Admin admin);
    void deleteAdmin(int admin_id);
    List<Admin> getAllAdmin();
    
}
