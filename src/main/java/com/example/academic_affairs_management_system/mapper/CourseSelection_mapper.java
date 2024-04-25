package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.CourseSelection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseSelection_mapper {

    @Insert("INSERT INTO course_selection(student_id, class_id, score) " +
            "VALUES(#{student_id}, #{class_id}, #{score})")
    void insertCourseSelection(CourseSelection courseSelection);

    @Select("<script>" +
            "SELECT * FROM course_selection" +
            "<where>" +
            "<if test='student_id != null'> AND student_id = #{student_id}</if>" +
            "<if test='class_id != null'> AND class_id = #{class_id}</if>" +
            "</where>" +
            "</script>")
    List<CourseSelection> findCourseSelections(Integer student_id, Integer class_id);

    @Update("<script>" +
            "UPDATE course_selection" +
            "<set>" +
            "<if test='score != null'>score = #{score},</if>" +
            "</set>" +
            "WHERE student_id = #{student_id} AND class_id = #{class_id}" +
            "</script>")
    void updateCourseSelection(CourseSelection courseSelection);

    @Delete("DELETE FROM course_selection WHERE student_id = #{student_id} AND class_id = #{class_id}")
    void deleteCourseSelection(int student_id, int class_id);

}
