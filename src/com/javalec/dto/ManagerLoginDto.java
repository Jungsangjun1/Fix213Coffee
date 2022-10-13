package com.javalec.dto;

import java.sql.Timestamp;

public class ManagerLoginDto {
	
	String employeeid;
	String employeepassword;
	String employeename;
	String employeephone;
	String employeegrade;
	java.sql.Timestamp employeeinitdate;
	java.sql.Timestamp employeeupdatedate;
	java.sql.Timestamp employeedeletedate;
	
	public ManagerLoginDto() {
		
	}
	
	public ManagerLoginDto(String employeeid, String employeepassword) {
		super();
		this.employeeid = employeeid;
		this.employeepassword = employeepassword;
		
	} //?

	public ManagerLoginDto(String employeeid, String employeepassword, String employeename, String employeephone,
			String employeegrade, Timestamp employeeinitdate, Timestamp employeeupdatedate,
			Timestamp employeedeletedate) {
		super();
		this.employeeid = employeeid;
		this.employeepassword = employeepassword;
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.employeegrade = employeegrade;
		this.employeeinitdate = employeeinitdate;
		this.employeeupdatedate = employeeupdatedate;
		this.employeedeletedate = employeedeletedate;
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

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeephone() {
		return employeephone;
	}

	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}

	public String getEmployeegrade() {
		return employeegrade;
	}

	public void setEmployeegrade(String employeegrade) {
		this.employeegrade = employeegrade;
	}

	public java.sql.Timestamp getEmployeeinitdate() {
		return employeeinitdate;
	}

	public void setEmployeeinitdate(java.sql.Timestamp employeeinitdate) {
		this.employeeinitdate = employeeinitdate;
	}

	public java.sql.Timestamp getEmployeeupdatedate() {
		return employeeupdatedate;
	}

	public void setEmployeeupdatedate(java.sql.Timestamp employeeupdatedate) {
		this.employeeupdatedate = employeeupdatedate;
	}

	public java.sql.Timestamp getEmployeedeletedate() {
		return employeedeletedate;
	}

	public void setEmployeedeletedate(java.sql.Timestamp employeedeletedate) {
		this.employeedeletedate = employeedeletedate;
	}

	
}
