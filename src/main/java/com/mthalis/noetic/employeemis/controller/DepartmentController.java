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

import com.mthalis.noetic.employeemis.dto.DepartmentDto;
import com.mthalis.noetic.employeemis.model.Department;
import com.mthalis.noetic.employeemis.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> getAlldepartment() {
		return departmentService.getAlldepartment();
	}

	@GetMapping("/{departmentId}")
	public DepartmentDto getDepartmentById(@PathVariable String departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

	@PostMapping
	public ResponseEntity<String> addDepartment(@RequestBody DepartmentDto department) {

		String deptId = departmentService.addDepartment(department);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(deptId).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable String departmentId) {
		departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}