package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_mapper {

    // 插入一个新的学生记录
    @Insert("INSERT INTO student(student_id, name, sex, date_of_birth, native_place, mobile_phone, dept_id, status) " +
            "VALUES(#{student_id}, #{name}, #{sex}, #{date_of_birth}, #{native_place}, #{mobile_phone}, #{dept_id}, #{status})")
    void insert_student(Student student);

    // 根据学生ID查询学生信息
    @Select("SELECT * FROM student WHERE student_id = #{student_id}")
    Student get_student_by_id(int student_id);

    // 更新学生信息
    @Update("<script>"
            + "UPDATE student SET "
            + "<if test='name != null'>name = #{name},</if>"
            + "<if test='sex != null'>sex = #{sex},</if>"
            + "<if test='date_of_birth != null'>date_of_birth = #{date_of_birth},</if>"
            + "<if test='native_place != null'>native_place = #{native_place},</if>"
            + "<if test='mobile_phone != null'>mobile_phone = #{mobile_phone},</if>"
            + "<if test='dept_id != null'>dept_id = #{dept_id},</if>"
            + "<if test='status != null'>status = #{status}</if>"
            + " WHERE student_id = #{student_id}"
            + "</script>")
    void update_student(Student student);

    // 删除一个学生记录
    @Delete("DELETE FROM student WHERE student_id = #{student_id}")
    void delete_student(int student_id);

    // 查询所有学生
    @Select("SELECT * FROM student WHERE student_id = #{student_id}")
    Student get_all_student(int student_id);
}
