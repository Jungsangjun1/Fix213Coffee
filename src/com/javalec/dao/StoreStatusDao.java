package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.StoreStatusDto;
import com.javalec.util.DBConnect;

public class StoreStatusDao {
	String branchid;
	int orderid;
	int takeid;
	int ordercount;

	public StoreStatusDao() {

	}

	public StoreStatusDao(String branchid, int orderid, int takeid, int ordercount) {
		super();
		this.branchid = branchid;
		this.orderid = orderid;
		this.takeid = takeid;
		this.ordercount = ordercount;
	}

	// 검색 결과를 Table
	public ArrayList<StoreStatusDto> selectList() {

		ArrayList<StoreStatusDto> dtoList = new ArrayList<StoreStatusDto>();

		String whereStatement = "select b.branchid, o.orderid, t.takeid, (1000-o.ordercount)\n"
				+ "	from branch b, manage m ,employee e, take t, orders o\n"
				+ "	where b.branchid = m.branch_branchid and m.employee_employeeid = e.employeeid and e.employeeid = t.employee_employeeid and t.orders_orderid = o.orderid; ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkbranchid = rs.getString(1);
				int wkorderid = rs.getInt(2);
				int wktakeid = rs.getInt(3);
				int wkordercount = rs.getInt(4);

				StoreStatusDto storeStatusDto = new StoreStatusDto(wkbranchid, wkorderid, wktakeid, wkordercount);
				dtoList.add(storeStatusDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	// 테이블 클릭하였을 때
//	public StoreStatusDto tableClick() {
//		StoreStatusDto dto = null;
//
//		String whereStatement = "select branchid from branch ";
//		String whereStatement2 = "where productid = " + "'" + branchid + "'";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
//					DBConnect.pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//
//			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
//
//			if (rs.next()) {
//				String wkbranchid = rs.getString(1);
//				int wkorderId = rs.getInt(2);
//				int wktakeid = rs.getInt(3);
//				int wkordercount = rs.getInt(4);
//
//				dto = new StoreStatusDto(wkbranchid, wkorderId, wktakeid, wkordercount);
//			}
//
//			conn_mysql.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return dto;
//
//	}

}
