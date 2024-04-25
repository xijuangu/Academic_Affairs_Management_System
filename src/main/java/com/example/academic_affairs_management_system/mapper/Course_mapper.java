package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Course_mapper {
    // 插入一个新的课程记录
    @Insert("INSERT INTO course(course_id, course_name, credit, credit_hours, dept_id, course_status) " +
            "VALUES(#{course_id}, #{course_name}, #{credit}, #{credit_hours}, #{dept_id}, #{course_status})")
    void insert_course(Course course);

    // 根据课程ID查询课程信息
    @Select("SELECT * FROM course WHERE course_id = #{course_id}")
    Course get_course_by_id(String course_id);

    // 更新课程信息
    @Update("<script>"
            + "UPDATE course SET "
            + "<if test='course_name != null'>course_name = #{course_name},</if>"
            + "<if test='credit != null'>credit = #{credit},</if>"
            + "<if test='credit_hours != null'>credit_hours = #{credit_hours},</if>"
            + "<if test='dept_id != null'>dept_id = #{dept_id},</if>"
            + "<if test='course_status != null'>course_status = #{course_status}</if>"
            + " WHERE course_id = #{course_id}"
            + "</script>")
    void update_course(Course course);

    // 删除一个课程记录
    @Delete("DELETE FROM course WHERE course_id = #{course_id}")
    void delete_course(String course_id);

    // 查询所有课程
    @Select("SELECT * FROM course WHERE course_id = #{course_id}")
    Course get_all_course(String course_id);
}
