package com.example.SpringBootTestProject.emoloyees;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> listOfEmployees() {
        return employeeService.getAllEmployees() ;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{EmployeeId}")
    public void deleteEmployee(@PathVariable("EmployeeId") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{EmployeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long id,
            @PathVariable(value = "email", required = false) String email,
            @PathVariable(value = "email", required = false) Integer salary) {
        employeeService.updateEmployee(id, email, salary);
    }

}
