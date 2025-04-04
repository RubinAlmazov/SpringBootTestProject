package com.example.SpringBootTestProject.emoloyees;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return (args) -> {
            var employeeList =  List.of(
                    new Employee(
                            null,
                            "Artem",
                            "artem@gmail.com",
                            LocalDate.of(2005,5,4),
                            10000
                    ),
                    new Employee(
                            null,
                            "Denis",
                            "denis@gmail.com",
                            LocalDate.of(2005, 7, 12),
                            10000
                    )
            );
            employeeRepository.saveAll(employeeList);
        };
    }
}
