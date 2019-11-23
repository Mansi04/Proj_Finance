package com.service;

import java.util.List;

import com.model.Admin;
import com.model.Users;

public interface AdminServiceIntf {
	public boolean validateAdmin(Admin admin);
	public boolean changepasswrd(String adname,String opwd, String npwd);
	public Users getApplicantDetailsbyId(String app_id);
	public List<Users> getAllMembers();
	public boolean checkUser(String app_id,String action);
}
