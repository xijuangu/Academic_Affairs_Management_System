package com.example.academic_affairs_management_system.controller;

import com.example.academic_affairs_management_system.pojo.CourseSelection;
import com.example.academic_affairs_management_system.service.CourseSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseSelection")
@CrossOrigin
public class CourseSelectionController {

    @Autowired
    private CourseSelectionService courseSelectionService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourseSelection(@RequestBody Map<String, String> requestMap) {
        String student_id = requestMap.get("student_id");
        String class_id = requestMap.get("class_id");
        String score = requestMap.get("score");
        String className = requestMap.get("className");

        if (student_id == null || class_id == null || score == null || className == null) {
            return new ResponseEntity<>("Missing fields in request. Required fields: 'student_id', 'class_id', 'score'", HttpStatus.BAD_REQUEST);
        }

        int studentId, classId, scoreValue;
        try {
            studentId = Integer.parseInt(student_id);
            classId = Integer.parseInt(class_id);
            scoreValue = Integer.parseInt(score);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid number format", HttpStatus.BAD_REQUEST);
        }

        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setStudentId(studentId);
        courseSelection.setClassId(classId);
        courseSelection.setScore(scoreValue);
        courseSelection.setClassName(className);

        courseSelectionService.insertCourseSelection(courseSelection);

        return new ResponseEntity<>("Course selection added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCourseSelection(
            @RequestParam(required = false) Integer studentId,
            @RequestParam(required = false) Integer classId) {

        if (studentId == null && classId == null) {
            return ResponseEntity.badRequest().body("At least one parameter (studentId or classId) is required.");
        }

        List<CourseSelection> courseSelections = courseSelectionService.findCourseSelections(studentId, classId);
        if (courseSelections.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(courseSelections, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCourseSelection(@RequestBody Map<String, String> requestMap) {
        String studentIdStr = requestMap.get("student_id");
        String classIdStr = requestMap.get("class_id");
        String scoreStr = requestMap.get("score");

        if (studentIdStr == null || classIdStr == null) {
            return new ResponseEntity<>("Student ID and Class ID are required for update.", HttpStatus.BAD_REQUEST);
        }

        

        int studentId, classId, score;
        try {
            studentId = Integer.parseInt(studentIdStr);
            classId = Integer.parseInt(classIdStr);
            score = Integer.parseInt(scoreStr); // Handle nullable score as optional update
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid format for IDs or score", HttpStatus.BAD_REQUEST);
        }

        List<CourseSelection> existingSelections = courseSelectionService.findCourseSelections(studentId, classId);
        if (existingSelections.isEmpty()) {
            return new ResponseEntity<>("Course selection not found.", HttpStatus.NOT_FOUND);
        }

        CourseSelection existingSelection = existingSelections.get(0);
        existingSelection.setScore(score);  // Assume score is the only updatable field
        courseSelectionService.updateCourseSelection(existingSelection);

        return new ResponseEntity<>("Course selection updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourseSelection(
            @RequestParam("studentId") int studentId,
            @RequestParam("classId") int classId) {

        // Check if the course selection exists
        List<CourseSelection> selections = courseSelectionService.findCourseSelections(studentId, classId);
        boolean exists = !selections.isEmpty();

        if (!exists) {
            return new ResponseEntity<>("No matching course selection found to delete.", HttpStatus.NOT_FOUND);
        }

        // If exists, execute delete operation
        courseSelectionService.deleteCourseSelection(studentId, classId);
        return new ResponseEntity<>("Course selection deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getByStaffId")
    public ResponseEntity<List<CourseSelection>> getCourseSelectionByStaffId(@RequestParam("staff_id") int staff_id){
        return new ResponseEntity<>(courseSelectionService.getCourseSelectionByStaffId(staff_id),HttpStatus.OK);
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<List<CourseSelection>> getAllCourseSelections() {
//        List<CourseSelection> selections = courseSelectionService.getAllCourseSelections();
//        if (selections.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(selections, HttpStatus.OK);
//    }
}
