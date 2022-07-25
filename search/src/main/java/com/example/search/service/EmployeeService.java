package com.example.search.service;


import com.example.employeeDemo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee(int... age);


}
