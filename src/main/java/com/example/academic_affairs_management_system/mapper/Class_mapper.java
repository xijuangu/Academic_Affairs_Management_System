package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface Class_mapper {

    // 插入一个新的班级记录
    @Insert("INSERT INTO class(semester, course_id, staff_id, class_time, place) " +
            "VALUES(#{semester}, #{course_id}, #{staff_id}, #{class_time}, #{place})")
    void insert_class(Class clazz);

    // 根据课程ID查询班级信息
    @Select("<script>" +
            "SELECT * FROM class" +
            "<where>" +
            "<if test='semester != null'> AND semester = #{semester}</if>" +
            "<if test='course_id != null'> AND course_id = #{course_id}</if>" +
            "<if test='staff_id != null'> AND staff_id = #{staff_id}</if>" +
            "</where>" +
            "</script>")
    List<Class> find_classes(String semester, String course_id, Integer staff_id);

    // 更新班级信息
    @Update("<script>"
            + "UPDATE class SET "
            + "<if test='class_time != null'>class_time = #{class_time},</if>"
            + "<if test='place != null'>place = #{place}</if>"
            + " WHERE course_id = #{course_id} AND semester = #{semester} AND staff_id = #{staff_id}"
            + "</script>")
    void update_class(Class clazz);

    // 删除一个班级记录
    @Delete("DELETE FROM class WHERE semester = #{semester} AND course_id = #{course_id} AND staff_id = #{staff_id}")
    void delete_class(String semester, String course_id, int staff_id);

    // 查询所有班级
    @Select("SELECT * FROM class")
    List<Class> get_all_class();
}
