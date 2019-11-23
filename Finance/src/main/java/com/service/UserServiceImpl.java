package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.ProdEmi;
import com.model.Products;
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

	public Users getStatusbyId(String app_id) {
		System.out.println("Service called");
		return userDao.getStatusbyId(app_id);
		
	}

	public ProdEmi getProdDetails(String pid) {
		Products products= userDao.getProdDetails(pid);
		// business logic
		ProdEmi prodEmi = new ProdEmi();
		prodEmi.setPid(products.getPid());
		prodEmi.setPcost(products.getPcost());
		prodEmi.setNineMonEmi(12000);
		prodEmi.setSixMonEmi(3400);
		return prodEmi;
	}


}
