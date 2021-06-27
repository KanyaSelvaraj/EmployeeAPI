package com.corporate.employee.controller;

import com.corporate.employee.entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static junit.framework.TestCase.assertSame;

@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEmployees(){
        ResponseEntity<List<Employee>> emp = employeeController.employees();
        assertSame(HttpStatus.OK, emp.getStatusCode());
    }
    @Test
    public void testEmployee(){
        ResponseEntity<List<Employee>> emp = employeeController.employees();
        assertSame(HttpStatus.OK, emp.getStatusCode());
    }


}
