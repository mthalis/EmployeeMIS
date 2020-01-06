package com.mthalis.noetic.employeemis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthalis.noetic.employeemis.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
