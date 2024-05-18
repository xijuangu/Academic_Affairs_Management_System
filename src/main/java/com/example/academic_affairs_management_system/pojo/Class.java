package com.example.academic_affairs_management_system.pojo;

public class Class {

    private String semester;
    private String course_id;
    private int staff_id;
    private String class_time;
    private String place;
    private int class_id;

    // getters and setters

    public int getClass_id(){ return class_id; }

    public void setClass_id(int class_id){ this.class_id = class_id; }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseId() {
        return course_id;
    }

    public void setCourseId(String course_id) {
        this.course_id = course_id;
    }

    public int getStaffId() {
        return staff_id;
    }

    public void setStaffId(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getClassTime() {
        return class_time;
    }

    public void setClassTime(String class_time) {
        this.class_time = class_time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Class{" +
                "semester='" + semester + '\'' +
                ", courseId='" + course_id + '\'' +
                ", staffId=" + staff_id +
                ", classTime='" + class_time + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
