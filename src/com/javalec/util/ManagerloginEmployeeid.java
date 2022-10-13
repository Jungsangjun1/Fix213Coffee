package com.javalec.util;

public class ManagerloginEmployeeid {
	
	public static String employeeid;
	
	public ManagerloginEmployeeid() {
	
	}

	public static String getEmployeeid() {
		return employeeid;
	}

	public static String setEmployeeid(String employeeid) {
		ManagerloginEmployeeid.employeeid = employeeid;
		return employeeid;
	}
	
	
}
