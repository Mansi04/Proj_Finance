package com.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class ProdEmi {

	private String pid;
	private String pname;
	private String pcategory;
	private int pcost;
	private String p_desc;
	private String p_image;
	private int threeMonEmi;
	private int sixMonEmi;
	private int nineMonEmi;
	private int twelveMonEmi;
	/*
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="pid")
	private EMI_Plan emi_Plan;*/
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	
	
	
	
	public String getP_desc() {
		return p_desc;
	}
	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public int getThreeMonEmi() {
		return threeMonEmi;
	}
	public void setThreeMonEmi(int threeMonEmi) {
		this.threeMonEmi = threeMonEmi;
	}
	public int getSixMonEmi() {
		return sixMonEmi;
	}
	public void setSixMonEmi(int sixMonEmi) {
		this.sixMonEmi = sixMonEmi;
	}
	public int getNineMonEmi() {
		return nineMonEmi;
	}
	public void setNineMonEmi(int nineMonEmi) {
		this.nineMonEmi = nineMonEmi;
	}
	public int getTwelveMonEmi() {
		return twelveMonEmi;
	}
	public void setTwelveMonEmi(int twelveMonEmi) {
		this.twelveMonEmi = twelveMonEmi;
	}
	
	
}
