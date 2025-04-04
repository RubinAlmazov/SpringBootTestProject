package com.example.SpringBootTestProject.emoloyees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("Id must be empty");
        }
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already taken");
        }
        if (employee.getSalary() <= 5000) {
            throw new IllegalArgumentException("Salary must be bigger");
        }
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Employee not found by id");
        }
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(Long id, String email, Integer salary) {
        var employee = employeeRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Employee not found"));
        if (email != null && !email.isEmpty() && email.equals(employee.getEmail())) {
            Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
            if (employeeOptional.isPresent()) {
                throw new IllegalArgumentException("Email already taken");
            }
            employee.setEmail(email);
        }
        if (salary <= 5000) {
            throw new IllegalArgumentException("Salary must be bigger");
        }
         employee.setSalary(salary);
    }

}
