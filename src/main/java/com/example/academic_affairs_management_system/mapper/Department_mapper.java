package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Department_mapper {
    @Insert("INSERT INTO department (dept_id, dept_name, address, phone_code) VALUES " +
            "(#{dept_id}, #{dept_name}, #{address}, #{phone_code})")
    void insert_department(Department department);

    @Select("SELECT * FROM department WHERE dept_id = #{dept_id}")
    Department get_department(int dept_id);

    @Update("<script>"
            + "UPDATE department SET "
            + "<if test='dept_name != null'>dept_name = #{dept_name},</if>"
            + "<if test='address != null'>address = #{address},</if>"
            + "<if test='phone_code != null'>phone_code = #{phone_code}</if>"
            + " WHERE dept_id = #{dept_id}"
            + "</script>")
    void update_department(Department department);

    @Delete("DELETE FROM department WHERE dept_id = #{dept_id}")
    void delete_department(int dept_id);

}
