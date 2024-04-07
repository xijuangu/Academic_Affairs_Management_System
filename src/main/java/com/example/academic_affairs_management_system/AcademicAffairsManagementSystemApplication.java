package com.example.academic_affairs_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.academic_affairs_management_system.mapper")
public class AcademicAffairsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicAffairsManagementSystemApplication.class, args);
	}

}
