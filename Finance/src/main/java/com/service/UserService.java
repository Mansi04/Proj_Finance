package com.service;

import java.util.List;

import com.model.ProdEmi;
import com.model.Products;
import com.model.Users;

public interface UserService {

	public boolean registerUser(Users users);
	public List<Products> getAllProducts();
	public List<Users> getAllMembers();
	public boolean changepasswrd(String username, String opwd, String npwd);
	public boolean validateUser(Users user);
	public Users getStatusbyId(String app_id);
	public ProdEmi getProdDetails(String pid);
	
}
