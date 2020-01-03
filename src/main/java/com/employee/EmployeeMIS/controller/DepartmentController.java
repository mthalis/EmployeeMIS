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

import com.employee.EmployeeMIS.model.Departments;
import com.employee.EmployeeMIS.service.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@GetMapping("/department/")
	public List<Departments> getAlldepartment() {
		return departmentRepository.findAll();
	}

	@GetMapping("/department/{departmentId}")
	public Departments getDepartmentById(@PathVariable String departmentId) {
		return departmentRepository.findOne(departmentId);
	}

	@PostMapping(path = "/department/")
	public ResponseEntity<Void> addDepartment(@RequestBody Departments departments) {

		Departments departmentOutput = departmentRepository.save(departments);
		if (departmentOutput == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(departments.getDepartmentID()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/department/{departmentId}")
	public ResponseEntity<Departments> deleteDepartment(@PathVariable String departmentId) {

		Departments department = departmentRepository.findOne(departmentId);
		if (department == null) {
			return new ResponseEntity<Departments>(HttpStatus.NOT_FOUND);
		}
		departmentRepository.delete(departmentId);
		return new ResponseEntity<Departments>(HttpStatus.NO_CONTENT);
	}
}