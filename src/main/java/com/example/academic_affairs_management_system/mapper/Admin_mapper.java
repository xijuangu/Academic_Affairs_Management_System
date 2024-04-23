package com.example.academic_affairs_management_system.mapper;

import com.example.academic_affairs_management_system.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Admin_mapper {

    // 插入一个新的管理员记录
    @Insert("INSERT INTO admin(admin_id, name, password) " +
            "VALUES(#{admin_id}, #{name}, #{password})")
    void insert_admin(Admin admin);

    // 根据管理员ID查询管理员信息
    @Select("SELECT * FROM admin WHERE admin_id = #{admin_id}")
    Admin get_admin_by_id(int admin_id);

    // 更新管理员信息
    @Update("<script>"
            + "UPDATE admin SET "
            + "<if test='name != null'>name = #{name},</if>"
            + "<if test='password != null'>password = #{password}</if>"
            + " WHERE admin_id = #{admin_id}"
            + "</script>")
    void update_admin(Admin admin);

    // 删除一个管理员记录
    @Delete("DELETE FROM admin WHERE admin_id = #{admin_id}")
    void delete_admin(int admin_id);

    // 查询所有管理员
    @Select("SELECT * FROM admin")
    List<Admin> get_all_admin();
}
