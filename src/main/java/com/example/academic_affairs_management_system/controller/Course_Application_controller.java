package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.mapper.Course_Application_mapper;
import com.example.academic_affairs_management_system.pojo.CourseApp;
import com.example.academic_affairs_management_system.service.Course_Application_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course_application")
@CrossOrigin
public class Course_Application_controller {

    @Autowired
    private Course_Application_service courseApplicationService;

    @Autowired
    private Course_Application_mapper courseApplicationMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addCourseApplication(@RequestBody Map<String, String> requestMap) {
        String course_application_id = requestMap.get("course_application_id");
        String staff_id = requestMap.get("staff_id");
        String course_id = requestMap.get("course_id");
        String course_name = requestMap.get("course_name");
        String course_hour = requestMap.get("course_hour");
        String course_credit = requestMap.get("course_credit");
        String course_time = requestMap.get("course_time");
        String course_place = requestMap.get("course_place");
        String examination_status = requestMap.get("examination_status");
        String apply_time = requestMap.get("apply_time");

        if (staff_id == null || course_id == null || course_name == null || course_hour == null || course_credit == null || course_time == null || course_place == null || examination_status == null || apply_time == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'course_application_id', 'staff_id', 'course_id', 'course_name', 'course_hour', 'course_credit', 'course_time', 'course_place', 'examination_status', 'apply_time'", HttpStatus.BAD_REQUEST);
        }

//        int ID;
//        try {
//            ID = Integer.parseInt(course_application_id);
//        } catch (NumberFormatException e) {
//            return new ResponseEntity<>("Invalid format for course_application_id", HttpStatus.BAD_REQUEST);
//        }

        CourseApp courseapp = new CourseApp();
        //courseapp.setCourseApplicationId(ID);
        courseapp.setStaffId(Integer.parseInt(staff_id));
        courseapp.setCourseId(course_id);
        courseapp.setCourseName(course_name);
        courseapp.setCourseHour(Integer.parseInt(course_hour));
        courseapp.setCourseCredit(Integer.parseInt(course_credit));
        courseapp.setCourseTime(course_time);
        courseapp.setCoursePlace(course_place);
        courseapp.setExaminationStatus(Integer.parseInt(examination_status));
        courseapp.setApplyTime(java.sql.Date.valueOf(apply_time));

        courseApplicationService.insertCourseApplication(courseapp);

        return new ResponseEntity<>("course_application added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{course_application_id}")
    public ResponseEntity<CourseApp> getCourseApplication(@PathVariable int course_application_id) {
        CourseApp courseapp = courseApplicationService.getCourseApplication(course_application_id);
        if (courseapp == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(courseapp, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCourseApplication(@RequestBody Map<String, String> requestMap) {
        String course_application_id = requestMap.get("course_application_id");
        if (course_application_id == null) {
            return new ResponseEntity<>("Course_Application ID is required for update.", HttpStatus.BAD_REQUEST);
        }

        int ID;
        try {
            ID = Integer.parseInt(course_application_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for course_application_id", HttpStatus.BAD_REQUEST);
        }

        CourseApp existingCourseApplication = courseApplicationService.getCourseApplication(ID);
        if (existingCourseApplication == null) {
            return new ResponseEntity<>("Course_Application not found.", HttpStatus.NOT_FOUND);
        }

        boolean isUpdated = false;
        if (requestMap.containsKey("staff_id")) {
            existingCourseApplication.setStaffId(Integer.parseInt(requestMap.get("staff_id")));
            isUpdated = true;
        }
        if (requestMap.containsKey("course_id")) {
            existingCourseApplication.setCourseId("course_id");
            isUpdated = true;
        }
        if (requestMap.containsKey("course_name")) {
            existingCourseApplication.setCourseName("course_name");
            isUpdated = true;
        }
        if (requestMap.containsKey("course_hour")) {
            existingCourseApplication.setCourseHour(Integer.parseInt(requestMap.get("course_hour")));
            isUpdated = true;
        }
        if (requestMap.containsKey("course_credit")) {
            existingCourseApplication.setCourseCredit(Integer.parseInt(requestMap.get("course_credit")));
            isUpdated = true;
        }
        if (requestMap.containsKey("course_time")) {
            existingCourseApplication.setCourseTime(requestMap.get("course_time"));
            isUpdated = true;
        }
        if (requestMap.containsKey("course_place")) {
            existingCourseApplication.setCoursePlace(requestMap.get("course_place"));
            isUpdated = true;
        }
        if (requestMap.containsKey("examination_status")) {
            existingCourseApplication.setExaminationStatus(Integer.parseInt(requestMap.get("examination_status")));
            isUpdated = true;
        }
        if (requestMap.containsKey("apply_time")) {
            try {
                existingCourseApplication.setApplyTime(java.sql.Date.valueOf(requestMap.get("apply_time")));
                isUpdated = true;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>("Invalid format for apply_time", HttpStatus.BAD_REQUEST);
            }
        }

        if (isUpdated) {
            courseApplicationService.updateCourseApplication(existingCourseApplication);
            return new ResponseEntity<>("Course_Application updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{course_application_id}")
    public ResponseEntity<?> deleteCourseApplication(@PathVariable("course_application_id") String course_application_id) {
        int ID;
        try {
            ID = Integer.parseInt(course_application_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for course_application_id", HttpStatus.BAD_REQUEST);
        }

        CourseApp courseapp = courseApplicationService.getCourseApplication(ID);
        if (courseapp == null) {
            return new ResponseEntity<>("Course_Application not found.", HttpStatus.NOT_FOUND);
        }

        courseApplicationService.deleteCourseApplication(ID);
        return new ResponseEntity<>("Course_Application deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<CourseApp> getAllCourseApplications() {
        return courseApplicationMapper.get_all_course_application();
    }
}
