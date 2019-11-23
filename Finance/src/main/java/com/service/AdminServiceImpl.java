package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDaoIntf;
import com.model.Admin;
import com.model.Users;
@Service("adminService")
public class AdminServiceImpl implements AdminServiceIntf {
	@Autowired
	  public AdminDaoIntf adminDao;

	@Transactional
	public boolean validateAdmin(Admin admin) {
		System.out.println("service called");
		boolean flag=adminDao.validateAdmin(admin);
		System.out.println(flag);
		return flag;
	}
	
	@Transactional
	public boolean changepasswrd(String username, String opwd, String npwd) {
		System.out.println("service called");
		boolean flag=adminDao.changepasswrd(username, opwd, npwd);
		System.out.println(flag);
		 return flag;
	}

	@Transactional
	public List<Users> getAllMembers() {
		List<Users> ulist = adminDao.getAllMembers();
		System.out.println("Service called");
		return ulist;
	}
	
	@Transactional
	public Users getApplicantDetailsbyId(String app_id) {
		System.out.println("Service called");
		return adminDao.getApplicantDetailsbyId(app_id);
	}

	@Transactional
	public boolean checkUser(String app_id , String action) {
		int result = adminDao.verifyUser(app_id,action);
		if(result == 1)
			return true;
		else
			return false;
	}

	
	
}
