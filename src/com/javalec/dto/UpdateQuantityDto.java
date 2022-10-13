package com.javalec.dto;

public class UpdateQuantityDto {

	String productid;
	int productprice;
	String productinitdate;
	String productkategorie;
	String productimage;
	String productdeletedate;
	
	public UpdateQuantityDto(String productid, int productprice, String productkategorie,
			String productimage) {
		super();
		this.productid = productid;
		this.productprice = productprice;
		this.productkategorie = productkategorie;
		this.productimage = productimage;
	}

	public UpdateQuantityDto(String productid, int productprice, String productinitdate,
			String productkategorie, String productimage, String productdeletedate) {
		super();
		this.productid = productid;
		this.productprice = productprice;
		this.productinitdate = productinitdate;
		this.productkategorie = productkategorie;
		this.productimage = productimage;
		this.productdeletedate = productdeletedate;
	}

	public UpdateQuantityDto() {
		// TODO Auto-generated constructor stub
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductinitdate() {
		return productinitdate;
	}

	public void setProductinitdate(String productinitdate) {
		this.productinitdate = productinitdate;
	}

	public String getproductkategorie() {
		return productkategorie;
	}

	public void setproductkategorie(String productkategorie) {
		this.productkategorie = productkategorie;
	}

	public String getProductimage() {
		return productimage;
	}

	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}

	public String getProductdeletedate() {
		return productdeletedate;
	}

	public void setProductdeletedate(String productdeletedate) {
		this.productdeletedate = productdeletedate;
	}

}
