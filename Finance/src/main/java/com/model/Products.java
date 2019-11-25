package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Products {

	@Id
	private String pid;
	private String pname;
	private String pcategory;
	private int pcost;
	private String p_desc;
	private String p_image;
	
	/*@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="pid")
	private EMI_Plan emi_Plan;
	*/
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
	/*public EMI_Plan getEmi_Plan() {
		return emi_Plan;
	}
	public void setEmi_Plan(EMI_Plan emi_Plan) {
		this.emi_Plan = emi_Plan;
	}
	*/
	/*public Products(String pid, String pname, String pcategory, int pcost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcategory = pcategory;
		this.pcost = pcost;
	}
	public Products() {
		super();
	}*/
	
	
}
