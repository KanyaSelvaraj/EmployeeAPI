package com.corporate.employee.service;

import com.corporate.employee.entity.Employee;
import com.corporate.employee.model.EmployeeModel;
import com.corporate.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    ModelMapper modelMapper = new ModelMapper();

    public Employee saveEmployee(Employee emp) {
        var employee = employeeRepository.save(emp);
        return employee;
    }

    public Optional<Employee> getEmployee(Long id) {
        var employee = employeeRepository.findById(id);
        return employee;
    }

    public List getEmployees() {
        List emps = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(emps::add);
        return emps;
    }

    public Employee updateEmployee(Long id, EmployeeModel employee) {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        Employee emp = modelMapper.map(employee, Employee.class);
        emp.setId(id);
        return employeeRepository.save(emp);
    }

}
