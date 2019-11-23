package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applicant")
public class Users {

	@Id
	private String app_id;
	
	private String fname;
	
	private String lname;
	private String contact_no;
	private String email;
	private String username;
	private String password;
	private String address;
	private String card_type;
	private String bank;
	private String account_no;
	private String ifsc;
	private String status;
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Users(String app_id, String fname, String lname, String contact_no, String email, String username,
			String password, String address, String card_type, String bank, String account_no, String ifsc,
			String status) {
		super();
		this.app_id = app_id;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.card_type = card_type;
		this.bank = bank;
		this.account_no = account_no;
		this.ifsc = ifsc;
		this.status = status;
	}
	public Users() {
		super();
	}
	
	
	
}
