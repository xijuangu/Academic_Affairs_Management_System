package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.pojo.Class;
import com.example.academic_affairs_management_system.service.Class_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/class")
@CrossOrigin
public class Class_controller {

    @Autowired
    private Class_service classService;

    @PostMapping("/add")
    public ResponseEntity<?> addClass(@RequestBody Map<String, String> requestMap) {
        String semester = requestMap.get("semester");
        String course_id = requestMap.get("course_id");
        String staff_id = requestMap.get("staff_id");
        String class_time = requestMap.get("class_time");
        String place = requestMap.get("place");

        if (semester == null || course_id == null || staff_id == null || class_time == null || place == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'semester', 'course_id', 'staff_id', 'class_time', 'place'", HttpStatus.BAD_REQUEST);
        }

        int staffID;
        try {
            staffID = Integer.parseInt(staff_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for staff_id", HttpStatus.BAD_REQUEST);
        }

        Class clazz = new Class();
        clazz.setSemester(semester);
        clazz.setCourseId(course_id);
        clazz.setStaffId(staffID);
        clazz.setClassTime(class_time);
        clazz.setPlace(place);

        classService.insertClass(clazz);

        return new ResponseEntity<>("Class added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getClass(
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String course_id,
            @RequestParam(required = false) Integer staff_id) {

        if (semester == null && course_id == null && staff_id == null) {
            return ResponseEntity.badRequest().body("At least one parameter (semester, course_id, staff_id) is required.");
        }

        List<Class> classes = classService.findClass(semester, course_id, staff_id);
        if (classes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(classes, HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<?> updateClass(@RequestBody Map<String, String> requestMap) {
        String semester = requestMap.get("semester");
        String courseId = requestMap.get("course_id");
        String staffIdStr = requestMap.get("staff_id");

        if (semester == null || courseId == null || staffIdStr == null) {
            return new ResponseEntity<>("Semester, course_id, and staff_id are required for update.", HttpStatus.BAD_REQUEST);
        }

        int staffId;
        try {
            staffId = Integer.parseInt(staffIdStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for staff_id", HttpStatus.BAD_REQUEST);
        }

        List<Class> existingClasses = classService.findClass(semester, courseId, staffId);
        if (existingClasses.isEmpty()) {
            return new ResponseEntity<>("Class not found.", HttpStatus.NOT_FOUND);
        }

        Class existingClass = existingClasses.get(0);  // 假设更新第一个匹配的班级
        boolean isUpdated = false;

        if (requestMap.containsKey("class_time")) {
            existingClass.setClassTime(requestMap.get("class_time"));
            isUpdated = true;
        }
        if (requestMap.containsKey("place")) {
            existingClass.setPlace(requestMap.get("place"));
            isUpdated = true;
        }

        if (isUpdated) {
            classService.updateClass(existingClass);
            return new ResponseEntity<>("Class updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No changes provided for update.", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClass(
            @RequestParam("semester") String semester,
            @RequestParam("course_id") String courseId,
            @RequestParam("staff_id") int staffId) {

        // 检查是否存在具有给定 semester, course_id, 和 staff_id 的班级
        List<Class> classes = classService.findClass(semester, courseId, staffId);
        boolean exists = classes.stream()
                .anyMatch(c -> c.getSemester().equals(semester) &&
                        c.getCourseId().equals(courseId) &&
                        c.getStaffId() == staffId);

        if (!exists) {
            return new ResponseEntity<>("No matching class found to delete.", HttpStatus.NOT_FOUND);
        }

        // 如果存在，执行删除操作
        classService.deleteClass(semester, courseId, staffId);
        return new ResponseEntity<>("Class deleted successfully: \n" + classes, HttpStatus.OK);
    }

    @GetMapping("/getAllClass")
    public ResponseEntity<List<Class>> getAllClass() {
        return new ResponseEntity<>(classService.getAllClass(), HttpStatus.OK);
    }

}
