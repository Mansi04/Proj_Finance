package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	private String user_id;
	
	private String fname;
	
	private String lname;
	private String email;
	private String username;
	private String password;
	private String address;
	private String card_type;
	private String bank;
	private String account_no;
	private String ifsc;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private CardDetails cardDetails;
	
	//one user can hold many emiplans
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<EMI_Plan> emi_Plan =  new ArrayList<EMI_Plan>();
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	
	
	public List<EMI_Plan> getEmi_Plan() {
		return emi_Plan;
	}
	public void setEmi_Plan(List<EMI_Plan> emi_Plan) {
		this.emi_Plan = emi_Plan;
	}
	public User(String user_id, String fname, String lname, String email, String username, String password,
			String address, String card_type, String bank, String account_no, String ifsc) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.card_type = card_type;
		this.bank = bank;
		this.account_no = account_no;
		this.ifsc = ifsc;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", username="
				+ username + ", password=" + password + ", address=" + address + ", card_type=" + card_type + ", bank="
				+ bank + ", account_no=" + account_no + ", ifsc=" + ifsc + ", cardDetails=" + cardDetails
				+ ", emi_Plan=" + emi_Plan + "]";
	}
	
	
	
}
