package com.employee.EmployeeMIS.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.EmployeeMIS.model.Employees;
import com.employee.EmployeeMIS.service.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employee/")
	public List<Employees> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Employees getEmployeeById(@PathVariable String employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	@PostMapping(path = "/employee/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employees employees) {

		Employees employeesOutput = employeeRepository.save(employees);
		if (employeesOutput == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employees.getEmployeeID()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<Employees> deleteEmployees(@PathVariable String employeeId) {

		Employees employees = employeeRepository.findOne(employeeId);
		if (employees == null) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
		employeeRepository.delete(employeeId);
		return new ResponseEntity<Employees>(HttpStatus.NO_CONTENT);
	}
}
