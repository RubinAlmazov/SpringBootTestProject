package com.example.SpringBootTestProject;

import com.example.SpringBootTestProject.emoloyees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@SpringBootApplication
public class SpringBootTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestProjectApplication.class, args);
	}

	@GetMapping
	public List<Employee> listOfEmployees() {
		return List.of(
				new Employee(
						1L,
						"Artem",
						"artem@gmail.com",
						LocalDate.of(2005,5,4),
						19,
						10000
				),
				new Employee(
						2L,
						"Denis",
						"denis@gmail.com",
						LocalDate.of(2005, 7, 12),
						19,
						10000
				)
		);
	}

}
