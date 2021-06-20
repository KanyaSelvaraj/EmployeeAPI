package com.corporate.employee.controller;

import com.corporate.employee.entity.Employee;
import com.corporate.employee.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("service")
@Log4j2
public class EmployeeController<ResponseEntityOptional> {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> employees() {
        List emps = new ArrayList<Employee>();

        employeeRepository.findAll().forEach(emps::add);
        return ResponseEntity.ok().body(emps);

    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> employee(@RequestBody Employee emp) {
        log.info("Inside post");
        var employee = employeeRepository.save(emp);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<Optional<Employee>> employee(@RequestParam Long id) {
        var employee  =  employeeRepository.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id, @RequestBody Employee emp) {
        emp.setId(id);
        var employee = employeeRepository.save(emp);
        return ResponseEntity.ok().body(employee);
    }

}