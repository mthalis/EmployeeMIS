package com.mthalis.noetic.employeemis.dto;

public class EmployeeDto {
	
	private String employeeID;
	private String firstname;
	private String lastname;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String employeeID, String firstname, String lastname) {
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
