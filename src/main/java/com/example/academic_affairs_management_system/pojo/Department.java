package com.example.academic_affairs_management_system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    int dept_id;

    @Column(length = 100)
    String dept_name;

    @Column(length = 255)
    String address;

    @Column(length = 20)
    String phone_code;

    public void setDept_id(int id)
    {
        this.dept_id=id;
    }

    public void setDept_name(String name)
    {
        this.dept_name=name;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }

    public void setPhone_code(String phone_code)
    {
        this.phone_code=phone_code;
    }


}
