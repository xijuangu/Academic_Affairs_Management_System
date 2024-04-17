package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.Department;

public interface Department_service {

    public void insert_department(Department department);

    public Department get_department(int dept_id);

    void update_department(Department department);

    void delete_department(int dept_id);

}
