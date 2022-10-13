package com.javalec.dto;

public class EmployeeSalesDto {

	
	String employeeid;
	int sequencenumber;
	
	public EmployeeSalesDto() {
		
	}

	public EmployeeSalesDto(int sequencenumber) {
		super();
		this.sequencenumber = sequencenumber;
	}

	public EmployeeSalesDto(String employeeid) {
		super();
		this.employeeid = employeeid;
	}

	public EmployeeSalesDto(String employeeid, int sequencenumber) {
		super();
		this.employeeid = employeeid;
		this.sequencenumber = sequencenumber;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public int getSequencenumber() {
		return sequencenumber;
	}

	public void setSequencenumber(int sequencenumber) {
		this.sequencenumber = sequencenumber;
	}



	

}
