package com.corporate.employee;

import com.corporate.employee.controller.EmployeeController;
import com.corporate.employee.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static junit.framework.TestCase.assertSame;

@SpringBootTest
class EmployeeApplicationTests {

	@InjectMocks
	private EmployeeApplication employeeApplication = new EmployeeApplication();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {

	}

	@InjectMocks
	EmployeeController employeeController;

	@org.junit.Test
	public void testEmployees(){
		ResponseEntity<List<Employee>> emp = employeeController.employees();
		assertSame(HttpStatus.OK, emp.getStatusCode());
	}
	@org.junit.Test
	public void testEmployee(){
		ResponseEntity<List<Employee>> emp = employeeController.employees();
		assertSame(HttpStatus.OK, emp.getStatusCode());
	}

}
