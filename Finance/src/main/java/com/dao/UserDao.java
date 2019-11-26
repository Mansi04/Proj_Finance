package com.dao;

import java.util.List;

import com.model.EMI_Plan;
import com.model.Installment;
import com.model.Products;
import com.model.User;
import com.model.Users;

public interface UserDao {

	public boolean registerUser(Users users); 
	public List<Products> getAllProducts();
	public List<Users> getAllMembers();
	public User validateUser(User user);
	public boolean changepasswrd(String username, String opwd, String npwd);
	public Users getStatusbyId(String app_id);
	public Products getProdDetails(String pid);
	public EMI_Plan getEmiplan(String emi,String pcost, User user);
	public List<Object[]>  getUserInstallmentHistory(User user,String emino);
	public List<Object[]>  getUserEmiHistory(User user);
}
