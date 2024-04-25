package com.example.academic_affairs_management_system.service.impl;

import com.example.academic_affairs_management_system.mapper.CourseSelection_mapper;
import com.example.academic_affairs_management_system.pojo.CourseSelection;
import com.example.academic_affairs_management_system.service.CourseSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {

    @Autowired
    private CourseSelection_mapper courseSelectionMapper;

    @Override
    public void insertCourseSelection(CourseSelection courseSelection) {
        courseSelectionMapper.insertCourseSelection(courseSelection);
    }

    @Override
    public List<CourseSelection> findCourseSelections(Integer studentId, Integer classId) {
        return courseSelectionMapper.findCourseSelections(studentId, classId);
    }

    @Override
    public void updateCourseSelection(CourseSelection courseSelection) {
        courseSelectionMapper.updateCourseSelection(courseSelection);
    }

    @Override
    public void deleteCourseSelection(int studentId, int classId) {
        courseSelectionMapper.deleteCourseSelection(studentId, classId);
    }
}
