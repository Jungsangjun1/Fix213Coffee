package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ManagerLoginDto;
import com.javalec.dto.ManagerLoginDto;
import com.javalec.util.DBConnect;

public class ManagerLoginDao {
	
	String employeeid;
	String employeepassword;

	
	
	public ManagerLoginDao() {
		
	}


	public ManagerLoginDao(String employeeid, String employeepassword) {
		super();
		this.employeeid = employeeid;
		this.employeepassword = employeepassword;
	}
	
	public ArrayList<ManagerLoginDto> loginAction(String employeeid) {

		ArrayList<ManagerLoginDto> dtoList = new ArrayList<ManagerLoginDto>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB불러오기
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);// 선언
			Statement stmt_mysql = conn_mysql.createStatement();
			// 불러올 때 java.sql을 불러와야함.

			String query = "select employeeid, employeepassword from coffeeshop.employee ";

			ResultSet rs = stmt_mysql.executeQuery(query);

			while (rs.next()) {

				String wkemployeeid= rs.getString(1);
				String wkemployeepassword= rs.getString(2);
				ManagerLoginDto dto = new ManagerLoginDto(wkemployeeid,wkemployeepassword);			
				dtoList.add(dto);
			}

			conn_mysql.close();// 불러온 DB를 닫아 줘야함.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;

	}

}
