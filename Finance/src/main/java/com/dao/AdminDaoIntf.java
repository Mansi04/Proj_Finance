package com.dao;

import java.util.List;

import com.model.Admin;
import com.model.Users;

public interface AdminDaoIntf {
	boolean validateAdmin(Admin admin);
	boolean changepasswrd(String adname,String opwd, String npwd);
	public List<Users> getAllMembers();
	Users getApplicantDetailsbyId(String app_id);
	public int verifyUser(String app_id, String action);
}
