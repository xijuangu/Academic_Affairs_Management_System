package com.example.academic_affairs_management_system.service;

import com.example.academic_affairs_management_system.pojo.CourseSelection;

import java.util.List;

public interface CourseSelectionService {

    void insertCourseSelection(CourseSelection courseSelection);

    List<CourseSelection> findCourseSelections(Integer studentId, Integer classId);

    public void updateCourseSelection(CourseSelection courseSelection);

    public void deleteCourseSelection(int studentId, int classId);

    public List<CourseSelection> getCourseSelectionByStaffId(int staff_id);

}
