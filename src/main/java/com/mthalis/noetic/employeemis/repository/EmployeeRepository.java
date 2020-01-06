package com.mthalis.noetic.employeemis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthalis.noetic.employeemis.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
