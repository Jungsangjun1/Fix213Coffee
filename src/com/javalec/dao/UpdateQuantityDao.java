package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.dto.MypageDto;
import com.javalec.dto.UpdateQuantityDto;
import com.javalec.util.DBConnect;
//import com.javalec.util.LoginCustId;
import com.javalec.util.LoginCustid;

public class UpdateQuantityDao {

	String productid;
	int productprice;
	String productinitdate;
	String productkategorie;
	String productimage;
	String productdeletedate;

	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거

	public UpdateQuantityDao() {
		// TODO Auto-generated constructor stub
	}

	public UpdateQuantityDao(String productid) {
		super();
		this.productid = productid;
	}

	public UpdateQuantityDao(String productid, int productprice, String productkategorie) {
		super();
		this.productid = productid;
		this.productprice = productprice;
		this.productkategorie = productkategorie;

	}

	public UpdateQuantityDao(String productid, int productprice, String productkategorie, String productimage) {
		super();
		this.productid = productid;
		this.productprice = productprice;
		this.productkategorie = productkategorie;
		this.productinitdate = productimage;
	}



	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}

	public Boolean deleteAction() {

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			String query = "update product set productid = ? , productdeletedate = now() ";
			String query2 = "where productid = ? ";

			ps = conn_mysql.prepareStatement(query + query2);
			ps.setString(1, productid);
			ps.setString(2, productid);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean updateAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB불러오기
			Connection conn_mysql = DriverManager.getConnection(com.javalec.util.DBConnect.url_mysql,
					com.javalec.util.DBConnect.id_mysql, com.javalec.util.DBConnect.pw_mysql);// 선언
			Statement mysql = conn_mysql.createStatement();
			// 불러올 때 java.sql을 불러와야함.

			String query = "update product set productid = ?, productprice = ?, productkategorie = ?, productupdatedate = now(), productimage = ? ";// 띄어쓰기를
			String query1 = "where productid = ? ";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, productid);
			ps.setInt(2, productprice);
			ps.setString(3, productkategorie);
			ps.setString(4, productimage);
			ps.setString(5, productid);

			ps.executeUpdate();

			conn_mysql.close();// 불러온 DB를 닫아 줘야함.

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean insertAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB불러오기
			Connection conn_mysql = DriverManager.getConnection(com.javalec.util.DBConnect.url_mysql,
					com.javalec.util.DBConnect.id_mysql, com.javalec.util.DBConnect.pw_mysql);// 선언
			Statement mysql = conn_mysql.createStatement();
			// 불러올 때 java.sql을 불러와야함.

			String query = "insert into product (productid, productprice, productkategorie, productinitdate) ";
			String query1 = "values (?,?,?, now())";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, productid);
			ps.setInt(2, productprice);
			ps.setString(3, productkategorie);
			ps.executeUpdate();

			conn_mysql.close();// 불러온 DB를 닫아 줘야함.

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	

}
