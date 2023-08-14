package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	@Operation(summary = "For adding employees")
	public Employee addEmp(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}

	@GetMapping("/getEmployees")
	@Operation(summary = "For display all employees detals")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	@Operation(summary = "For display employee details by ID")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int id){
		return empService.getEmployeeById(id);		
	}
	
	@PutMapping("/updateEmployee/{id}")
	@Operation(summary = "For updating employees details")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") int id, Employee employee) {
		return empService.updateEmployee(id, employee);	
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	@Operation(summary = "For delete employee")
	public ResponseEntity<String> deleteEmployee(int id){
		return empService.deleteEmployee(id);
		
	}
}
