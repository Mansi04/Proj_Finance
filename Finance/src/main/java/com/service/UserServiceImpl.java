package com.service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.EMI_Plan;
import com.model.Installment;
import com.model.ProdEmi;
import com.model.Products;
import com.model.User;
import com.model.Users;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	//-------------------------------------User Registration---------------------------------------------//
	@Transactional
	public boolean registerUser(Users users) {
		System.out.println("Service called");
		boolean flag= userDao.registerUser(users);
		System.out.println(flag);
		return flag;
		
	}
	
	//-------------------------------------Getting all Products---------------------------------------------//
	@Transactional
	public List<Products> getAllProducts() {
		List<Products> plist = userDao.getAllProducts();
		System.out.println("Service called");
		return plist;
	}
	
	//-------------------------------------Getting all Members List who are approved---------------------------------------------//
	@Transactional
	public List<Users> getAllMembers() {
		List<Users> ulist = userDao.getAllMembers();
		System.out.println("Service called");
		return ulist;
	}
	//-------------------------------------Change Password for User---------------------------------------------//
	@Transactional
	public boolean changepasswrd(String username, String opwd, String npwd) {
		System.out.println("service called");
		boolean flag=userDao.changepasswrd(username, opwd, npwd);
		System.out.println(flag);
		 return flag;
	}
	
	//-------------------------------------Validating User for Login---------------------------------------------//
	@Transactional
	public User validateUser(User user) {
		System.out.println("service called");
		User flag=userDao.validateUser(user);
		System.out.println(flag);
		return flag;
	}

	//-------------------------------------Get Status of Applicants---------------------------------------------//
	@Transactional
	public Users getStatusbyId(String app_id) {
		System.out.println("Service called");
		return userDao.getStatusbyId(app_id);
		
	}

	//-------------------------------------Getting Product Details and Calculating Emi Based on Cost of Product---------------------------------------------//
	@Transactional
	public ProdEmi getProdDetails(String pid) {
		User user = new User();

		String user_id = user.getUser_id();
		System.out.println("Service Called"+user_id);
		Products products= userDao.getProdDetails(pid);
		// business logic
				
		ProdEmi prodEmi = new ProdEmi();
		prodEmi.setPid(products.getPid());
		prodEmi.setPname(products.getPname());
		prodEmi.setPcategory(products.getPcategory());
		prodEmi.setP_desc(products.getP_desc());
		prodEmi.setP_image(products.getP_image());
		prodEmi.setPcost(products.getPcost());
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		
		String emi_no = "E"+new Date();
		
		int cost = products.getPcost();
		
		if(cost<50000){
			
			int threeEmi = cost/3;
			prodEmi.setThreeMonEmi(threeEmi);
			int sixEmi = cost/6;
			prodEmi.setSixMonEmi(sixEmi);			
		}else if(cost>50000 && cost<70000){
			int threeEmi = cost/3;
			prodEmi.setThreeMonEmi(threeEmi);
			int sixEmi = cost/6;
			prodEmi.setSixMonEmi(sixEmi);
			int nineEmi = cost/9;
			prodEmi.setNineMonEmi(nineEmi);
			
		}else{
			int threeEmi = cost/3;
			prodEmi.setThreeMonEmi(threeEmi);
			int sixEmi = cost/6;
			prodEmi.setSixMonEmi(sixEmi);
			int nineEmi = cost/9;
			prodEmi.setNineMonEmi(nineEmi);
			int twelveEmi = cost/12;
			prodEmi.setTwelveMonEmi(twelveEmi);
		}
			return prodEmi;
	}

	//-------------------------------------Getting Emi Plan for a User ---------------------------------------------//
	@Transactional
	public EMI_Plan getEmiplan(String emi,String pcost, User user) {
		EMI_Plan emi_Plan=new EMI_Plan();
		

		emi_Plan = userDao.getEmiplan(emi,pcost,user);
		System.out.println(emi_Plan.getInstallment_amt());
		System.out.println("Service Called"+emi_Plan);
		return emi_Plan;
	}

	//-------------------------------------Getting Users Installment History---------------------------------------------//
	
	@Transactional
	public List<Object[]>  getUserInstallmentHistory(User user,String emino) {
		List<Object[]>  installments = userDao.getUserInstallmentHistory(user,emino);
		System.out.println("Service called"+installments);
		System.out.println("Service Called"+emino);
		return installments;
	}

	@Transactional
	public List<Object[]>  getUserEmiHistory(User user){
		return userDao.getUserEmiHistory(user);
	}

	

}
