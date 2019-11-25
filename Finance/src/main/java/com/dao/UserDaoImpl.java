package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.EMI_Plan;
import com.model.Installment;
import com.model.Products;
import com.model.User;
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
		/*User user = em.find(User.class, user_id);
		Products products=  em.find(Products.class, pid);
		EMI_Plan emi_Plan=new EMI_Plan();
		
			user.setEmi_Plan(emi_Plan);
			products.setEmi_Plan(emi_Plan);
				em.persist(user);
				em.persist(prod);*/
		
		return prod;
	}


	public EMI_Plan getEmiplan(String emi,String pcost) {
		EMI_Plan emi_Plan=new EMI_Plan();
		
		  String emis[] = emi.split(":"); //[0]  plan [1] cost
		    emi_Plan.setTenure(emis[0]);
		    emi_Plan.setInstallment_amt(Integer.parseInt(emis[1]));
		    emi_Plan.setS_date(new Date());
		    emi_Plan.setE_date(new Date());
		    emi_Plan.setPcost(Integer.parseInt(pcost));

		    Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int emi1 = (Integer.parseInt(emis[0]));
			cal.add(Calendar.MONTH, emi1);
			Date expirationDate = cal.getTime();
			emi_Plan.setE_date(expirationDate);
		    
		    User user = new User();
		    user.setUser_id("U1574504043511"); // take from sesion
		    emi_Plan.setUser(user);
		    System.out.println(emi_Plan.getTenure());
		
			String emi_no = "E"+new Date().getTime();
			emi_Plan.setEmi_no(emi_no);
		
			
			
			// making entries into Installments table
			for(int i=1; i<=emi1; i++){
				Date date1 = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(date1);
   			    c.add(Calendar.MONTH, i);
				Date dd = c.getTime();
				
				Installment installment = new Installment();
				/*String inst = "I"+new Date().getTime();
				installment.setInstallment_no(inst);*/
				installment.setEmi_Plan(emi_Plan);
				installment.setDue_date(dd);
				installment.setNo_installments(i);
				installment.setInstall_amt(Integer.parseInt(emis[1]));
				emi_Plan.getEmi_Plan().add(installment);
				installment.setEmi_Plan(emi_Plan);

			}
	
			em.persist(emi_Plan);			
			//System.out.println(emi_Plan.getInstallment_amt());
			System.out.println("DAO CALLEd"+emi_Plan);
		return emi_Plan;
	}

	
	
	// --------------------------------------------------------------------------------------------------//
	// Getting history of user installments
	public List<Object[]>  getUserInstallmentHistory(){
		
	
			String sql = "select i.* from Installment i, Emi_Plan e where i.emi_no = e.emi_no";
			List<Object[]> users = em.createNativeQuery(sql).getResultList();
			System.out.println("Dao Called"+users);
			return users;
		
	}
	
	

}
