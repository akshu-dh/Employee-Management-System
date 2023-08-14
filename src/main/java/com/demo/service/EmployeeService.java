package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.demo.model.Employee;

public interface EmployeeService {
		
	public Employee addEmployee(Employee emp);

	public List<Employee> getAllEmployee();
	
	public ResponseEntity<Employee> getEmployeeById(int id);
	
	public ResponseEntity<?> updateEmployee(int id, Employee employee);
	
	public ResponseEntity<String> deleteEmployee(int id);
		
}
