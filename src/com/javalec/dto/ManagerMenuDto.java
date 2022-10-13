package com.javalec.dto;

public class ManagerMenuDto {

	String employeeid;
	String employeepassword;
	
	public ManagerMenuDto() {
		// TODO Auto-generated constructor stub
	}

	public ManagerMenuDto(String employeeid) {
		super();
		this.employeeid = employeeid;
	}

	public ManagerMenuDto(String employeeid, String employeepassword) {
		super();
		this.employeeid = employeeid;
		this.employeepassword = employeepassword;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeepassword() {
		return employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	
	
	

}
