package com.employee.EmployeeMIS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departments {

	@Id
	private String departmentID;
	private String name;

	public Departments() {
		super();
	}

	public Departments(String departmentID, String name) {
		super();
		this.departmentID = departmentID;
		this.name = name;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
