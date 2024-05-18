package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.CourseApp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Course_Application_mapper {

    //插入一个新的课程申请记录
    @Insert("INSERT INTO course_application(course_application_id, staff_id, course_id, course_name, course_hour, course_credit, course_time, course_place, examination_status, apply_time) " +
            "VALUES(#{course_application_id}, #{staff_id}, #{course_id}, #{course_name}, #{course_hour}, #{course_credit}, #{course_time}, #{course_place}, #{examination_status}, #{apply_time})")
    void insert_course_application(CourseApp courseapp);

    //根据课程申请ID查询课程申请信息
    @Select("SELECT * FROM course_application WHERE course_application_id = #{course_application_id}")
    CourseApp get_course_application_by_id(int course_application_id);

    // 更新课程申请信息
    @Update("<script>"
            + "UPDATE course_application SET "
            + "<if test='staff_id != null'>staff_id = #{staff_id},</if>"
            + "<if test='course_id != null'>course_id = #{course_id},</if>"
            + "<if test='course_name != null'>course_name = #{course_name},</if>"
            + "<if test='course_hour != null'>course_hour = #{course_hour},</if>"
            + "<if test='course_credit != null'>course_credit = #{course_credit},</if>"
            + "<if test='course_time != null'>course_time = #{course_time},</if>"
            + "<if test='course_place != null'>course_place = #{course_place},</if>"
            + "<if test='examination_status != null'>examination_status = #{examination_status},</if>"
            + "<if test='apply_time != null'>apply_time = #{apply_time}</if>"
            + " WHERE course_application_id = #{course_application_id}"
            + "</script>")
    void update_course_application(CourseApp courseapp);

    // 删除一个课程申请记录
    @Delete("DELETE FROM course_application WHERE course_application_id = #{course_application_id}")
    void delete_course_application(int course_application_id);

    // 查询所有课程申请
    @Select("SELECT * FROM course_application")
    List<CourseApp> get_all_course_application();
}
