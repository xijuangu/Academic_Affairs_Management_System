package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.Department_mapper;
import com.example.academic_affairs_management_system.pojo.Department;
import com.example.academic_affairs_management_system.service.Department_service;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class Department_service_impl implements Department_service {

    Department_mapper mapper;

    @Override
    public void insert_department(Department department) {
        mapper.insert_department(department);
    }
}
