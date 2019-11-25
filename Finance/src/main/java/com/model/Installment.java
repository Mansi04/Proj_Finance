package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;

@Entity
public class Installment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int installment_no;
	private int no_installments;
	private int install_amt;
	@Temporal(TemporalType.DATE)
	private Date due_date;
	
	@ManyToOne
	@JoinColumn(name="emi_no")
	EMI_Plan emi_Plan;
	

	/*public String getInstallment_no() {
		return installment_no;
	}

	public void setInstallment_no(String installment_no) {
		this.installment_no = installment_no;
	}*/

	public int getInstallment_no() {
		return installment_no;
	}

	public void setInstallment_no(int installment_no) {
		this.installment_no = installment_no;
	}

	public int getNo_installments() {
		return no_installments;
	}

	public void setNo_installments(int no_installments) {
		this.no_installments = no_installments;
	}

	public int getInstall_amt() {
		return install_amt;
	}

	public void setInstall_amt(int install_amt) {
		this.install_amt = install_amt;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public EMI_Plan getEmi_Plan() {
		return emi_Plan;
	}

	public void setEmi_Plan(EMI_Plan emi_Plan) {
		this.emi_Plan = emi_Plan;
	}


	
	
	
}
