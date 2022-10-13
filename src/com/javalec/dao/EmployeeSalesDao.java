package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.EmployeeSalesDto;
import com.javalec.dto.EmployeeSalesDto;
import com.javalec.util.DBConnect;

public class EmployeeSalesDao {

	String employeeid;
	int sequencenumber;

	public EmployeeSalesDao() {

	}

	public EmployeeSalesDao(String employeeid, int sequencenumber) {
		super();
		this.employeeid = employeeid;
		this.sequencenumber = sequencenumber;
	}

	// 검색 결과를 Table
	public ArrayList<EmployeeSalesDto> selectList() {

		ArrayList<EmployeeSalesDto> dtoList = new ArrayList<EmployeeSalesDto>();
		String whereStatement = "    select e.employeeid, sum(o.ordercount)\n"
				+ "	from employee e, take t, orders o\n"
				+ "	where o.orderid = t.orders_orderid and t.employee_employeeid=e.employeeid\n"
				+ "    group by e.employeeid; ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkemployeeid = rs.getString(1);
				int wksequencenumber = rs.getInt(2);

				EmployeeSalesDto EmployeeSalesDto = new EmployeeSalesDto(wkemployeeid, wksequencenumber);
				dtoList.add(EmployeeSalesDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}
//		public EmployeeSalesDto tableClick() {
//			EmployeeSalesDto dto = null;
//
//			String whereStatement = "select e.employeename, sum(o.sequencenumber)\n"
//					+ "from employee e, take t, orders o" ;
//			String whereStatement2 = "where e.employeename = 'bb' and"
//					+ "e.employeeid = e.employeeid and o.orderid = o.orderid " ;
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
//						DBConnect.pw_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//
//				ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement2);
//
//				if (rs.next()) {
//					String wkemployeeid = rs.getString(1);
//					int wksequenenumber = rs.getInt(2);
//					
//
//					dto = new EmployeeSalesDto(wkemployeeid, wksequenenumber);
//				}
//
//				conn_mysql.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			return dto;
//		}

}
