package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.Products;
import com.model.Users;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	public boolean registerUser(Users users) {
		boolean result= false;
		try {
			em.persist(users);
			System.out.println("in persist");
		/*	em.getTransaction().commit();*/
			System.out.println("in commit");		
			result=true;
				
		} catch (Exception e) {
			
			System.out.println(e);
			System.out.println("User already registered");
		}
			
		return result;
		
	}
	
	//view all products
	public List<Products> getAllProducts(){
		System.out.println("DAO called");
		Products p = null;
		List<Products> mlist =new ArrayList<Products>();
		try{
			List<Products> products = em.createQuery("select p from Products p").getResultList();
			return products;
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return mlist;
	}

	//view all members for admin
	public List<Users> getAllMembers() {
		System.out.println("DAO called");
		Users u = null;
		List<Users> ulist =new ArrayList<Users>();
		try{
			List<Users> users = em.createQuery("select u from Users u").getResultList();
			return users;					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ulist;
	}

	public boolean validateUser(Users user) {
		boolean flag=false;
		
		Users f =null;
		try{
			
			f=(Users)em.createQuery("SELECT f FROM Users f WHERE f.username=:uname and f.password=:pwd")
		         .setParameter("uname", user.getUsername())
		         .setParameter("pwd",user.getPassword())
		         .getSingleResult();
			System.out.println(f);
		/*	f=em.find(Users.class, user.getUsername()); */
			if(f!=null){
				//if(f.getPassword().equals(user.getPassword()))
					flag=true;
			}
			/*em.close();*/
			
		}
		catch(Exception e) {System.out.println(e); }
		
		System.out.println(f);
		return flag;
		}

	public boolean changepasswrd(String username, String opwd, String npwd) {
		boolean flag=false;
		
		  Query query = em.createQuery("update Users u set u.password=:npwd where u.username=:username and u.password=:opwd");
		  query.setParameter("npwd", npwd);
		  query.setParameter("opwd", opwd);
		  query.setParameter("username", username);
		   int r = query.executeUpdate();
		/*  em.getTransaction().commit();*/
		  System.out.println("working");
		 // em.close();
		  if(r>0)
			  flag=true;
		  return flag;
	  }

	// Tracking user application status
	
	public Users getStatusbyId(String app_id) {
		@SuppressWarnings("unchecked")
		Users user = (Users) em.createQuery("select u from Users u where u.app_id=:app_id")
				.setParameter("app_id",app_id).getSingleResult();		
		return user;
	}

	// Viewing particular product's details
	
	public Products getProdDetails(String pid) {
		Products prod = (Products) em.createQuery("select p from Products p where p.pid=:pid")
				.setParameter("pid", pid).getSingleResult();
		return prod;
	}
	
	// 
	
	

}
