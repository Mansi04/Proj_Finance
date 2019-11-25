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
	
	@Transactional
	public boolean registerUser(Users users) {
		System.out.println("Service called");
		boolean flag= userDao.registerUser(users);
		System.out.println(flag);
		return flag;
		
	}
	
	@Transactional
	public List<Products> getAllProducts() {
		List<Products> plist = userDao.getAllProducts();
		System.out.println("Service called");
		return plist;
	}
	
	@Transactional
	public List<Users> getAllMembers() {
		List<Users> ulist = userDao.getAllMembers();
		System.out.println("Service called");
		return ulist;
	}
	
	@Transactional
	public boolean changepasswrd(String username, String opwd, String npwd) {
		System.out.println("service called");
		boolean flag=userDao.changepasswrd(username, opwd, npwd);
		System.out.println(flag);
		 return flag;
	}
	
	@Transactional
	public boolean validateUser(Users user) {
		System.out.println("service called");
		boolean flag=userDao.validateUser(user);
		System.out.println(flag);
		return flag;
	}

	@Transactional
	public Users getStatusbyId(String app_id) {
		System.out.println("Service called");
		return userDao.getStatusbyId(app_id);
		
	}

	@Transactional
	public ProdEmi getProdDetails(String pid) {
		User user = new User();

		String user_id = user.getUser_id();
		System.out.println("Service Called"+user_id);
		Products products= userDao.getProdDetails(pid);
		/*EMI_Plan emi_Plan= new EMI_Plan();*/
		
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
		//planning emi depending upon the cost of the product
		// and too emi plan is generated for that user after clicking 
		String emi_no = "E"+new Date();
		/*emi_Plan.setEmi_no(emi_no);
		emi_Plan.setTenure(emi);*/
		int cost = products.getPcost();
		
		if(cost<50000){
			
			int threeEmi = cost/3;
			prodEmi.setThreeMonEmi(threeEmi);
			/*if(emi.equalsIgnoreCase("three_mon"))
			{
				emi_Plan.setInstallment_amt(threeEmi);
				emi_Plan.setS_date(new Date());
				cal.setTime(date);
				cal.add(Calendar.MONTH, 3);
				Date expirationDate = cal.getTime();
				emi_Plan.setE_date(expirationDate);
			}
			*/
			int sixEmi = cost/6;
			prodEmi.setSixMonEmi(sixEmi);
			/*emi_Plan.setInstallment_amt(sixEmi);*/
			
			//setting end date
				
			
			
		}else if(cost>50000 && cost<70000){
			int threeEmi = cost/3;
			prodEmi.setThreeMonEmi(threeEmi);
			/*emi_Plan.setInstallment_amt(threeEmi);*/
			int sixEmi = cost/6;
			prodEmi.setSixMonEmi(sixEmi);
			/*emi_Plan.setInstallment_amt(sixEmi);*/
			int nineEmi = cost/9;
			prodEmi.setNineMonEmi(nineEmi);
			/*emi_Plan.setInstallment_amt(nineEmi);*/
			
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
	/*	products.setEmi_Plan(emi_Plan);*/

	
		return prodEmi;
	}

	@Transactional
	public EMI_Plan getEmiplan(String emi,String pcost) {
		EMI_Plan emi_Plan=new EMI_Plan();
		

		emi_Plan = userDao.getEmiplan(emi,pcost);
		System.out.println(emi_Plan.getInstallment_amt());
		System.out.println("Service Called"+emi_Plan);
		return emi_Plan;
	}

	public List<Object[]>  getUserInstallmentHistory() {
		List<Object[]>  installments = userDao.getUserInstallmentHistory();
		System.out.println("Service called"+installments);
		return installments;
	}


}
