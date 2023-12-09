package product.model;

import java.util.Date;

public class Product {
	
	private int p_no;
	private String p_name;
	private int p_seoul;
	private int p_suwon;
	private int p_incheon;
	private int price;
	
	public Product(int p_no, String p_name, int p_seoul, int p_suwon, int p_incheon, int price) {
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_seoul = p_seoul;
		this.p_suwon = p_suwon;
		this.p_incheon = p_incheon;
		this.price = price;
	}

	public int getP_No() {
		return p_no;
	}

	public void setP_No(int p_no) {
		this.p_no = p_no;
	}

	public String getP_Name() {
		return p_name;
	}

	public void setP_Name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_Seoul() {
		return p_seoul;
	}

	public void setP_Seoul(int p_seoul) {
		this.p_seoul = p_seoul;
	}

	public int getP_Suwon() {
		return p_suwon;
	}

	public void setP_Suwon(int p_suwon) {
		this.p_suwon = p_suwon;
	}

	public int getP_Incheon() {
		return p_incheon;
	}

	public void setP_Incheon(int p_incheon) {
		this.p_incheon = p_incheon;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



}
