package com.example.academic_affairs_management_system.pojo;

import java.sql.Date;

public class Teacher {

    private int staff_id;
    private String name;
    private char sex;
    private String professional_ranks;
    private String salary;
    private Date date_of_birth;
    private String password;

    private int dept_id;

    // Getters and Setters
    public int getTeacherId() {
        return staff_id;
    }

    public void setTeacherId(int staffId) {
        this.staff_id = staffId;
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

    public String getProfessionalRanks() {
        return professional_ranks;
    }

    public void setProfessionalRanks(String professionalRanks) {this.professional_ranks = professionalRanks;}

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return dept_id;
    }

    public void setDepartment(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
