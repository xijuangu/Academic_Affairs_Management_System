package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.pojo.Course;
import com.example.academic_affairs_management_system.service.Course_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class Course_controller {
    @Autowired
    private Course_service courseService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Map<String, String> requestMap) {
        String course_id = requestMap.get("course_id");
        String course_name = requestMap.get("course_name");
        String credit = requestMap.get("credit");
        String credit_hours = requestMap.get("credit_hours");
        String dept_id = requestMap.get("dept_id");
        String course_status = requestMap.get("course_status");

        if (course_id == null || course_name == null || credit == null || credit_hours == null || dept_id == null || course_status == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'course_id', 'course_name', 'credit', 'credit_hours', 'dept_id', 'course_status'", HttpStatus.BAD_REQUEST);
        }

//        int ID;
//        try {
//            ID = Integer.parseInt(course_id);
//        } catch (NumberFormatException e) {
//            return new ResponseEntity<>("Invalid format for course_id", HttpStatus.BAD_REQUEST);
//        }

        Course course = new Course();
        course.setCourseId(course_id);
        course.setCourseName(course_name);
        course.setCredit(Integer.parseInt(credit));
        course.setCreditHours(Integer.parseInt(credit_hours));
        course.setDepartment(Integer.parseInt(dept_id));
        course.setCourseStatus(Integer.parseInt(course_status));

        courseService.insertCourse(course);

        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{course_id}")
    public ResponseEntity<Course> getCourse(@PathVariable String course_id) {
        Course course = courseService.getCourse(course_id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody Map<String, String> requestMap) {
        String course_id = requestMap.get("course_id");
        if (course_id == null) {
            return new ResponseEntity<>("Course ID is required for update.", HttpStatus.BAD_REQUEST);
        }

//        int ID;
//        try {
//            ID = Integer.parseInt(course_id);
//        } catch (NumberFormatException e) {
//            return new ResponseEntity<>("Invalid format for course_id", HttpStatus.BAD_REQUEST);
//        }

        Course existingCourse = courseService.getCourse(course_id);
        if (existingCourse == null) {
            return new ResponseEntity<>("Course not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("course_name")) {
            existingCourse.setCourseName(requestMap.get("course_name"));
            isUpdated = true;
        }
        if (requestMap.containsKey("credit")) {
            existingCourse.setCredit(Integer.parseInt(requestMap.get("credit")));
            isUpdated = true;
        }
        if (requestMap.containsKey("credit_hours")) {
            existingCourse.setCreditHours(Integer.parseInt(requestMap.get("credit_hours")));
            isUpdated = true;
        }
        if (requestMap.containsKey("dept_id")) {
            try {
                existingCourse.setDepartment(Integer.parseInt(requestMap.get("dept_id")));
                isUpdated = true;
            } catch (NumberFormatException e) {
                return new ResponseEntity<>("Invalid format for dept_id", HttpStatus.BAD_REQUEST);
            }
        }
        if (requestMap.containsKey("course_status")) {
            existingCourse.setCourseStatus(Integer.parseInt(requestMap.get("course_status")));
            isUpdated = true;
        }

        if (isUpdated) {
            courseService.updateCourse(existingCourse);
            return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("course_id") String course_id) {
//        int ID;
//        try {
//            ID = Integer.parseInt(course_id);
//        } catch (NumberFormatException e) {
//            return new ResponseEntity<>("Invalid format for course_id", HttpStatus.BAD_REQUEST);
//        }

        Course course = courseService.getCourse(course_id);
        if (course == null) {
            return new ResponseEntity<>("Course not found.", HttpStatus.NOT_FOUND);
        }

        courseService.deleteCourse(course_id);
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }

}
