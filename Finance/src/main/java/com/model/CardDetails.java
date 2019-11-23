package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CardDetails {

	@Id
	private String card_no;
	@Temporal(TemporalType.DATE)
	private Date val_startdate;
	@Temporal(TemporalType.DATE)
	private Date val_expiredate;
	private int credit_limit;
	private int credit_used;
	private int credit_remaining;
	
	@OneToOne
	@JoinColumn(name="user_id")
	User user;

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public Date getVal_startdate() {
		return val_startdate;
	}

	public void setVal_startdate(Date val_startdate) {
		this.val_startdate = val_startdate;
	}

	public Date getVal_expiredate() {
		return val_expiredate;
	}

	public void setVal_expiredate(Date val_expiredate) {
		this.val_expiredate = val_expiredate;
	}

	public int getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(int credit_limit) {
		this.credit_limit = credit_limit;
	}

	public int getCredit_used() {
		return credit_used;
	}

	public void setCredit_used(int credit_used) {
		this.credit_used = credit_used;
	}

	public int getCredit_remaining() {
		return credit_remaining;
	}

	public void setCredit_remaining(int credit_remaining) {
		this.credit_remaining = credit_remaining;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
