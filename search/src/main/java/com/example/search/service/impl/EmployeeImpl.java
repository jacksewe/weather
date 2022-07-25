package com.example.search.service.impl;


import com.example.employeeDemo.Employee;
import com.example.employeeDemo.EmployeeList;
import com.example.search.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Employee> getEmployee(int... age) {
        final String url = "https://dummy.restapiexample.com/api/v1/employees";
        EmployeeList employees = new EmployeeList();
        employees.setEmployees(restTemplate
                .getForObject(url, EmployeeList.class).getEmployees());
        List<Employee> result = new ArrayList<>();
        for(int i: age){
            List<Employee> filtered = employees.getEmployees().stream()
                    .filter(e -> e.getEmployee_age() == i)
                    .collect(Collectors.toList());
            for(Employee e: filtered){
                result.add(e);
            }
        }
        return result;
    }
}




