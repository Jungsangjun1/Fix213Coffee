package com.javalec.dto;

public class StoreStatusDto {

	
	String branchid;
	int orderid;
	int takeid;
	int ordercount;
	
	public StoreStatusDto(String branchid, int orderid, int takeid, int ordercount) {
		super();
		this.branchid = branchid;
		this.orderid = orderid;
		this.takeid = takeid;
		this.ordercount = ordercount;
	}

	
	public StoreStatusDto() {
		
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getTakeid() {
		return takeid;
	}

	public void setTakeid(int takeid) {
		this.takeid = takeid;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	
	

}
