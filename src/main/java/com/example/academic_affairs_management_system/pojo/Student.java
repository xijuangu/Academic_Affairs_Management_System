package com.example.academic_affairs_management_system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;


public class Student {

        private int student_id;
        private String name;
        private char sex;
        private Date date_of_birth;
        private String native_place;
        private String mobile_phone;
        private int dept_id;
        private String status;

    // Getters and Setters
    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int studentId) {
        this.student_id = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.date_of_birth = dateOfBirth;
    }

    public String getNativePlace() {
        return native_place;
    }

    public void setNativePlace(String nativePlace) {
        this.native_place = nativePlace;
    }

    public String getMobilePhone() {
        return mobile_phone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobile_phone = mobilePhone;
    }

    public int getDepartment() {
        return dept_id;
    }

    public void setDepartment(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
