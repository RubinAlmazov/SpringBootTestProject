package com.example.SpringBootTestProject;

import com.example.SpringBootTestProject.emoloyees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class SpringBootTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestProjectApplication.class, args);
	}


}
