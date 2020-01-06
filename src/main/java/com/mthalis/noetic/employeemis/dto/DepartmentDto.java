package com.mthalis.noetic.employeemis.dto;

public class DepartmentDto {

	private String departmentID;
	private String name;

	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String departmentID, String name) {
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
