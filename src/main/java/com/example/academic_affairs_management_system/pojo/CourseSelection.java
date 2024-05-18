package com.example.academic_affairs_management_system.pojo;

public class CourseSelection {

    private int student_id;
    private int class_id;
    private int score;

    private String className;


    //getters and setters

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public int getClassId() {
        return class_id;
    }

    public void setClassId(int class_id) {
        this.class_id = class_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    // toString method
    @Override
    public String toString() {
        return "CourseSelection{" +
                "student_id=" + student_id +
                ", class_id=" + class_id +
                ", score=" + score +
                '}';
    }

}
