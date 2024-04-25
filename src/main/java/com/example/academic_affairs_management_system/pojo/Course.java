package com.example.academic_affairs_management_system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class Course {

    private String course_id;
    private String course_name;
    private int credit;
    private int credit_hours;
    private int dept_id;
    private int course_status;

    // Getters and Setters
    public String getCourseId() {
        return course_id;
    }

    public void setCourseId(String courseId) {
        this.course_id = courseId;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String courseName) {
        this.course_name = courseName;
    }

    public int getCredit() { return credit; }

    public void setCredit(int credit) { this.credit = credit; }

    public int getCreditHours() { return credit_hours; }

    public void setCreditHours(int credit_hours) { this.credit_hours = credit_hours; }

    public int getDepartment() {
        return dept_id;
    }

    public void setDepartment(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getCourseStatus() { return course_status; }

    public void setCourseStatus(int course_status) {
        this.course_status = course_status;
    }
}
