package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.CardDetails;
import com.model.User;
import com.model.Users;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDaoIntf {

	@PersistenceContext
	EntityManager em;
	
	public boolean validateAdmin(Admin admin) {
		boolean flag=false;
		
		Admin f =null;
		try{
			f=(Admin)em.createQuery("SELECT f FROM Admin f WHERE f.username=:username and f.password=:password")
		         .setParameter("username", admin.getUsername())
		         .setParameter("password", admin.getPassword())
		         .getSingleResult();
			System.out.println(f);
			
			if(f!=null){
			//	if(f.getAdpass().equals(admin.getPassword())
					flag=true;
			}
			//em.close();
		}
		catch(Exception e) {System.out.println(e); }
		
		System.out.println(f);
		return flag;
		}
	
	public boolean changepasswrd(String username, String opwd, String npwd) {
		 boolean flag=false;
		  
		  Query query = em.createQuery("update Admin u set u.password=:npwd where u.username=:username and u.password=:opwd");
		  query.setParameter("npwd", npwd);
		  query.setParameter("opwd", opwd);
		  query.setParameter("username", username);
		   int r = query.executeUpdate();
		 
		  System.out.println("working");
		  if(r>0)
			  flag=true;
		  return flag;
	  }
	
	//view all members for admin
		public List<Users> getAllMembers() {
			System.out.println("DAO called");
			Users u = null;
			List<Users> ulist =new ArrayList<Users>();
			try{
				List<Users> users = em.createQuery("select u from Users u where u.status='approved'").getResultList();
				return users;					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return ulist;
		}
		
		
		//viewing details of user by getting application id
	public Users getApplicantDetailsbyId(String app_id) {
		@SuppressWarnings("unchecked")
		Users user = (Users) em.createQuery("select u from Users u where u.app_id=:app_id")
				.setParameter("app_id",app_id).getSingleResult();		
		return user;
	}
	
	//verifying user
	public int verifyUser(String app_id, String action) {
		System.out.println(app_id+"  "+action);
		String user_id = "U"+ new Date().getTime();
		String card_no = "C"+ new Date().getTime();
		String jpql = "Update Users u set u.status=:action where u.app_id=:app_id";
		Query query = em.createQuery(jpql).setParameter("app_id", app_id).setParameter("action", action);
		int result = query.executeUpdate();
		
		Users applicant= em.find(Users.class, app_id);	//Applicant table
		User user = new User();			//User table
		if(result == 1)
		{
			//em.persist(applicant); //persisting applicant object
			if(action.equalsIgnoreCase("approved"))
			{
				user.setUser_id(user_id);
				user.setFname(applicant.getFname());
				user.setLname(applicant.getLname());
				user.setEmail(applicant.getEmail());
				user.setUsername(applicant.getUsername());
				user.setPassword(applicant.getPassword());
				user.setAddress(applicant.getAddress());
				user.setCard_type(applicant.getCard_type());
				user.setBank(applicant.getBank());
				user.setAccount_no(applicant.getAccount_no());
				user.setIfsc(applicant.getIfsc());
				
				CardDetails cardDetails = new CardDetails();
				cardDetails.setCard_no(card_no);
				cardDetails.setUser(user);
				cardDetails.setVal_startdate(new Date());
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.YEAR, 2);
				Date expirationDate = cal.getTime();
				cardDetails.setVal_expiredate(expirationDate);
				if(user.getCard_type().equalsIgnoreCase("gold"))
				{
					cardDetails.setCredit_limit(200000);
					cardDetails.setCredit_remaining(200000);
				}
				else
				{
					cardDetails.setCredit_limit(250000);
					cardDetails.setCredit_remaining(250000);
				}
				
				cardDetails.setCredit_used(0);
				cardDetails.setCredit_remaining(0);
				
				user.setCardDetails(cardDetails);
				em.persist(user);
				
			}
			
		}
		return result;
	}
}


