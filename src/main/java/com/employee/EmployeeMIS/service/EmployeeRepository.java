package com.employee.EmployeeMIS.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeMIS.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, String> {

}
