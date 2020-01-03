package com.employee.EmployeeMIS.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeMIS.model.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, String> {

}
