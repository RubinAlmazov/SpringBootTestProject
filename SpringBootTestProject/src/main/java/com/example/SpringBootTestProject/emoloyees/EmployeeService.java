package com.example.SpringBootTestProject.emoloyees;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getAllEmployees() {
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
