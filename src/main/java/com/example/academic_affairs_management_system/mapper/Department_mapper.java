package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Department_mapper {
    @Insert("INSERT INTO department (dept_id, dept_name, address, phone_code) VALUES " +
            "(#{dept_id}, #{dept_name}, #{address}, #{phone_code})")
    void insert_department(Department department);

    @Select("SELECT * FROM department WHERE dept_id = #{dept_id}")
    Department get_department(int dept_id);
}
