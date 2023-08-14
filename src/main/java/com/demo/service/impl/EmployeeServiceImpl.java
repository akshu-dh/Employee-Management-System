package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repo.EmployeeRepo;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		Employee saveEmp = empRepo.save(emp);
		return saveEmp;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> getEmp = empRepo.findAll();
		return getEmp;
	}

	@Override
	public ResponseEntity<?> updateEmployee(int id, Employee employee) {
		Optional<Employee> getEmpById = empRepo.findById(id);
		if(getEmpById.isPresent()) {
			Employee employee2 = getEmpById.get();
			employee2.setName(employee.getName());
			employee2.setAddress(employee.getAddress());
			employee2.setDept(employee.getDept());
			employee2.setSalary(employee.getSalary());
			Employee save = empRepo.save(employee2);
			return ResponseEntity.ok().body(save);
			
		}
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int id) {
		Optional<Employee> getEmpById = empRepo.findById(id);
		if(getEmpById.isPresent()) {
			return ResponseEntity.ok().body(getEmpById.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<String> deleteEmployee(int id) {
		Optional<Employee> deleteEmpById = empRepo.findById(id);
		if(deleteEmpById.isPresent()) {
			empRepo.deleteById(id);
			return new ResponseEntity<>("Employee deleted successful", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}

	

	

	
}
