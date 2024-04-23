package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Admin_mapper;
import com.example.academic_affairs_management_system.pojo.Admin;
import com.example.academic_affairs_management_system.service.Admin_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin_service_impl implements Admin_service {

    @Autowired
    private Admin_mapper adminMapper;

    @Override
    public void insertAdmin(Admin admin) {
        adminMapper.insert_admin(admin);
    }

    @Override
    public Admin getAdmin(int adminId) {
        return adminMapper.get_admin_by_id(adminId);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.update_admin(admin);
    }

    @Override
    public void deleteAdmin(int adminId) {
        adminMapper.delete_admin(adminId);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.get_all_admin();
    }

}
