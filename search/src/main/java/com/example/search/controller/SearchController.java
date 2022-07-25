package com.example.search.controller;

import com.example.employeeDemo.Employee;
import com.example.search.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SearchController {
    private final EmployeeService EmployeeService;

    @Autowired
    public SearchController(EmployeeService EmployeeService) {
        super();
        this.EmployeeService = EmployeeService;
    }

    @GetMapping("/weather/search")
    @HystrixCommand(fallbackMethod = "getFallbackMethod")
    public ResponseEntity<?> getDetails(@RequestParam int... age) {
//        //TODO
//        return new ResponseEntity<>("this is search service", HttpStatus.OK);
        return new ResponseEntity<List<Employee>>(EmployeeService.getEmployee(age), HttpStatus.OK);
    }
    public ResponseEntity<?> getFallBackMethod(){
        return new ResponseEntity<List<Employee>>(Arrays.asList(new Employee()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
