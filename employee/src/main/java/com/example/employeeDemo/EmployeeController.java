package com.example.employeeDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
    final String url = "https://dummy.restapiexample.com/api/v1/employees";
    EmployeeList employees = new EmployeeList();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        this.employees.setEmployees(this.restTemplate
                .getForObject(this.url, EmployeeList.class).getEmployees());
        return this.employees.getEmployees();
    }

    @GetMapping("/employees/age")
    public List<Employee> getEmployeesOlderThan(@RequestParam int age) {
        this.employees.setEmployees(this.restTemplate
                .getForObject(this.url, EmployeeList.class).getEmployees());
        return this.employees.getEmployees().stream()
                .filter(e -> e.getEmployee_age() > age)
                .collect(Collectors.toList());
    }

}
