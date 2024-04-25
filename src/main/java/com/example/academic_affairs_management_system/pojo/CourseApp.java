package com.example.academic_affairs_management_system.pojo;

import java.sql.Date;

public class CourseApp {
    private int course_application_id;
    private int staff_id;
    private String course_id;
    private String course_name;
    private int course_hour;
    private int course_credit;
    private String course_time;
    private String course_place;
    private int examination_status;
    private Date apply_time;

    // Getters and Setters
    public int getCourseApplicationId() {
        return course_application_id;
    }

    public void setCourseApplicationId(int courseApplicationId) {
        this.course_application_id = courseApplicationId;
    }

    public int getStaffId() { return staff_id; }

    public void setStaffId(int staffId) { this.staff_id = staffId; }

    public String getCourseId() { return course_id; }

    public void setCourseId(String courseId) { this.course_id = courseId; }

    public String getCourseName() { return course_name; }

    public void setCourseName(String courseName) { this.course_name = courseName; }

    public int getCourseHour() { return course_hour; }

    public void setCourseHour(int courseHour) { this.course_hour = courseHour; }

    public int getCourseCredit() { return course_credit; }

    public void setCourseCredit(int courseCredit) { this.course_credit = courseCredit; }

    public String getCourseTime() { return course_time; }

    public void setCourseTime(String courseTime) { this.course_time = courseTime; }

    public String getCoursePlace() { return course_place; }

    public void setCoursePlace(String coursePlace) { this.course_place = coursePlace; }

    public int getExaminationStatus() { return examination_status; }

    public void setExaminationStatus(int examinationStatus) { this.examination_status = examinationStatus; }

    public Date getApplyTime() { return apply_time; }

    public void setApplyTime(Date applyTime) { this.apply_time = applyTime; }
}
