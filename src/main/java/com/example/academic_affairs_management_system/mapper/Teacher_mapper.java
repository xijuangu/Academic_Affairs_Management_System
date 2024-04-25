package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Teacher_mapper {
    // 插入一个新的教师记录
    @Insert("INSERT INTO teacher(staff_id, name, sex, date_of_birth, professional_ranks, salary, dept_id, password) " +
            "VALUES(#{staff_id}, #{name}, #{sex}, #{date_of_birth}, #{professional_ranks}, #{salary}, #{dept_id}, #{password})")
    void insert_teacher(Teacher teacher);

    // 根据学生ID查询教师信息
    @Select("SELECT * FROM teacher WHERE staff_id = #{staff_id}")
    Teacher get_teacher_by_id(int staff_id);

    // 更新教师信息
    @Update("<script>"
            + "UPDATE teacher SET "
            + "<if test='name != null'>name = #{name},</if>"
            + "<if test='sex != null'>sex = #{sex},</if>"
            + "<if test='date_of_birth != null'>date_of_birth = #{date_of_birth},</if>"
            + "<if test='professional_ranks != null'>professional_ranks = #{professional_ranks},</if>"
            + "<if test='salary != null'>salary = #{salary},</if>"
            + "<if test='dept_id != null'>dept_id = #{dept_id},</if>"
            + "<if test='password != null'>password = #{password}</if>"
            + " WHERE staff_id = #{staff_id}"
            + "</script>")
    void update_teacher(Teacher teacher);

    // 删除一个教师记录
    @Delete("DELETE FROM teacher WHERE staff_id = #{staff_id}")
    void delete_teacher(int staff_id);

    // 查询所有教师
    @Select("SELECT * FROM teacher WHERE staff_id = #{staff_id}")
    Teacher get_all_teacher(int staff_id);
}
