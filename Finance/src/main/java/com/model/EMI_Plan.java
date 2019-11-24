package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EMI_Plan {

	@Id
	private String emi_no;
	private int installment_amt;
	private Date s_date;
	private Date e_date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	/*@ManyToOne
	@JoinColumn(name="pid")
	ProdEmi prodEmi;
	*/
	public String getEmi_no() {
		return emi_no;
	}
	public void setEmi_no(String emi_no) {
		this.emi_no = emi_no;
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
	
	
}
