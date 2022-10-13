package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ManagerMenuDto;
import com.javalec.dto.StoreStatusDto;
import com.javalec.util.DBConnect;
import com.javalec.util.LoginCustid;
import com.javalec.util.ManagerloginEmployeeid;

public class ManagerMenuDao {
	
	String employeeid;
	String employeepassword;
	
	public ManagerMenuDao() {
		// TODO Auto-generated constructor stub
	}
	

	


	public ManagerMenuDao(String employeeid, String employeepassword) {
		super();
		this.employeeid = employeeid;
		this.employeepassword = employeepassword;
	}





	public ArrayList<ManagerMenuDto> selectList() {

		ArrayList<ManagerMenuDto> dtoList = new ArrayList<ManagerMenuDto>();

		String whereStatement = "select employeeid, employeepassword from employee; ";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			while (rs.next()) {
				String wkemployeeid = rs.getString(1);
				String wkemployeepassword = rs.getString(2);
				ManagerMenuDto managerMenuDto = new ManagerMenuDto(wkemployeeid, wkemployeepassword);
				dtoList.add(managerMenuDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}
	public ArrayList<ManagerMenuDto> selectList1() {

		ArrayList<ManagerMenuDto> dtoList = new ArrayList<ManagerMenuDto>();

		String whereStatement = "select employeeid from employee where employeeid = '" + ManagerloginEmployeeid.getEmployeeid() + "'";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			while (rs.next()) {
				String wkemployeeid = rs.getString(1);
				ManagerMenuDto managerMenuDto = new ManagerMenuDto(wkemployeeid);
				dtoList.add(managerMenuDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;


	}
	

}
//"select employeeid from employee where employeeid = '" + ManagerloginEmployeeid.getEmployeeid() + "'"