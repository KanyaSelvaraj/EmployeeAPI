package com.corporate.employee.controller;

import com.corporate.employee.entity.Employee;
import com.corporate.employee.model.EmployeeModel;
import com.corporate.employee.repository.EmployeeRepository;
import com.corporate.employee.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("service")
@Log4j2
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> employees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> employee(@RequestBody Employee emp) {
        log.info("Inside post");
        var employee = employeeService.saveEmployee(emp);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<Optional<Employee>> employee(@RequestParam Long id) {
        var employee  =  employeeService.getEmployee(id);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id, @RequestBody EmployeeModel emp) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(id,emp));
    }

}