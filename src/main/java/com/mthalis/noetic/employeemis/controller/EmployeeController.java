package com.mthalis.noetic.employeemis.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mthalis.noetic.employeemis.dto.EmployeeDto;
import com.mthalis.noetic.employeemis.model.Employee;
import com.mthalis.noetic.employeemis.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{employeeId}")
	public EmployeeDto getEmployeeById(@PathVariable String employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody EmployeeDto employeeDto) {

		String empId = employeeService.addEmployee(employeeDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empId).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable String employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
}
