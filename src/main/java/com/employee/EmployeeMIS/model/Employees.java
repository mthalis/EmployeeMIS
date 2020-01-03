package com.employee.EmployeeMIS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employees {

	@Id
	private String employeeID;
	private String firstname;
	private String lastname;

	public Employees() {
		super();
	}

	public Employees(String employeeID, String firstname, String lastname) {
		super();
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
