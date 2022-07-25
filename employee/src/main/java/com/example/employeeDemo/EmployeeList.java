package com.example.employeeDemo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeList {
    @JsonProperty("data")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
