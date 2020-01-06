package com.mthalis.noetic.employeemis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthalis.noetic.employeemis.dto.DepartmentDto;
import com.mthalis.noetic.employeemis.exception.DepartmentNotFoundException;
import com.mthalis.noetic.employeemis.model.Department;
import com.mthalis.noetic.employeemis.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAlldepartment() {
		return departmentRepository.findAll();
	}

	public DepartmentDto getDepartmentById(String departmentId) {
		Department department = departmentRepository.findOne(departmentId);
		if(department == null) {
			throw new DepartmentNotFoundException("Department ID Not Found : " + departmentId);
		}
		return new DepartmentDto(department.getDepartmentID(),department.getName());
	}
	
	public String addDepartment(DepartmentDto department) {
		Department dept = new Department(department.getDepartmentID(),department.getName());
		return departmentRepository.save(dept).getDepartmentID();
	}

	public void deleteDepartment(String departmentId) throws DepartmentNotFoundException {		
		departmentRepository.delete(departmentId);
	}
}
