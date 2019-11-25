package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EMI_Plan {

	@Id
	private String emi_no;
	private String tenure;
	private int installment_amt;
	private Date s_date;
	private Date e_date;
	private int pcost;
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="emi_no")
	private List<Installment> emi_Plan =  new ArrayList<Installment>();
	
	
	public String getEmi_no() {
		return emi_no;
	}
	public void setEmi_no(String emi_no) {
		this.emi_no = emi_no;
	}
	
	
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public int getInstallment_amt() {
		return installment_amt;
	}
	public void setInstallment_amt(int installment_amt) {
		this.installment_amt = installment_amt;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public List<Installment> getEmi_Plan() {
		return emi_Plan;
	}
	public void setEmi_Plan(List<Installment> emi_Plan) {
		this.emi_Plan = emi_Plan;
	}
	
	
	
	
	
	
}
