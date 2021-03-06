package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.EMI_Plan;
import com.model.Installment;
import com.model.ProdEmi;
import com.model.Products;
import com.model.User;
import com.model.Users;
import com.service.UserService;
import com.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	  public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("registration");
	    mav.addObject("user", new Users());
	    return mav;
	  }
	@RequestMapping(value="/register" ,method=RequestMethod.POST )
	public ModelAndView registerUser(HttpServletRequest request,HttpServletResponse response){
		
		String app_id= "A"+ new Date().getTime();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String contact_no=request.getParameter("contact");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String card_type=request.getParameter("card_type");
		String bank=request.getParameter("bank");
		String account_no=request.getParameter("account_no");
		String ifsc=request.getParameter("ifsc");
		String status="pending";
		
		
		Users users =null;
		users = new Users(app_id,fname, lname, contact_no, email, username, password, address, card_type, bank, account_no, ifsc, status);
		
		boolean flag= userservice.registerUser(users);
		
		if(flag){
			
			 //  ModelAndView mav = new ModelAndView("redirect:/index.jsp");
			  ModelAndView mav = new ModelAndView("applicantId");
			   mav.addObject("username", username);
			   mav.addObject("status", "You have successfully registered. Please visit our nearest branch for further verification");
			   mav.addObject("users",users);
			   return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("home1");
			mav.addObject("status", "Not Registered");
			return mav;
		}		
	}
//-------------------------------------------------------------------------------//	
	//Getting status for particular applicant
	@RequestMapping(value = "/track", method = RequestMethod.GET)
	  public ModelAndView trackStatus(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("getStatus");
	    mav.addObject("user", new Users());
	    return mav;
	  }
	
	@RequestMapping(value = "/trackStatus", method = RequestMethod.POST)
	  public ModelAndView getStatusbyId(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 ModelAndView mav = new ModelAndView();
		 String app_id = request.getParameter("app_id");
		 Users ulist = userservice.getStatusbyId(app_id);
		 mav.addObject("ulist",ulist);
		 mav.setViewName("home");
		 return mav;
   }
	
//------------------------------------------------------------------------------------//
	// Login and password
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("loginuser");
	    mav.addObject("user", new Users());
	    return mav;
	     }
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	  public ModelAndView userHome(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("Welcome");
	    mav.addObject("user", new Users());
	    return mav;
	     }
	
	
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@ModelAttribute User user, HttpSession session) {
		  System.out.println(user.getEmail()+"\n"+user.getPassword());	  
		
	     User flag = userservice.validateUser(user);
	     
	       if(flag!=null) {
	    	   System.out.println("flag="+flag);
	    	   
	    	   ModelAndView mav = new ModelAndView();
	    	   mav.addObject("status","Login Success");
	    	   //session manage
	    	   session.setAttribute("user", flag);
	    	   mav.addObject("user", flag);
	    	   System.out.println(flag.getUser_id()+"Session");
	    	   mav.setViewName("Welcome");
	    	   return mav;
    }
    else {
  	  ModelAndView mav = new ModelAndView();
   	 mav.addObject("status","Login Failed");
   	mav.setViewName("loginuser");
   	return mav;
    }
}  
    
  //--------------------------------------------------------------------------------//
	  // Changing Password for User

	  
	  @RequestMapping(value = "/changepasswrd", method = RequestMethod.GET)
	  public ModelAndView changepwd1(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("changepasswrd");
	    return mav;
	  }
	@RequestMapping(value = "/changepasswrd", method = RequestMethod.POST)
	  public ModelAndView changepwd2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
      String username=(String)session.getAttribute("user");
      String opwd= request.getParameter("opassword");
      String npwd= request.getParameter("npassword");
    
      boolean flag = userservice.changepasswrd(username,opwd,npwd);
      if(flag) {
	       ModelAndView mav = new ModelAndView("changepasswrd");
	       mav.addObject("message", "Password is successfully updated");
	       return mav;
	  }
      else {
      	ModelAndView mav = new ModelAndView("changepasswrd");
		       mav.addObject("message", "Password is not updated");
		       return mav;
      }
	}
	
//---------------------------------------------------------------------------------//
	//Getting Details of each product 
	//Buying Options of each product on the same page
	
	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	  public ModelAndView getProdDetails(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("prodDetails");
	   String pid = request.getParameter("pid");
	   String emi =  request.getParameter("emi");
	   ProdEmi prod = userservice.getProdDetails(pid);
	   mav.addObject("prod",prod);
	   System.out.println(pid);
	  
	    return mav;
	     }
	
	
//---------------------------------------------------------------------------------------//
	//Getting Emi Plan
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	  public ModelAndView getPaymentDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	    ModelAndView mav = new ModelAndView("payment");
	    String emi = request.getParameter("emi");
	    String user_id = request.getParameter("user_id");
	    String pcost = request.getParameter("pcost");    
	    
	    User user =(User)session.getAttribute("user");
	    EMI_Plan emi_Plan= userservice.getEmiplan(emi,pcost,user);
	    
	    
	    System.out.println("Controller called"+emi_Plan.getInstallment_amt());
	    
	    
	    mav.addObject("emi_Plan",emi_Plan);
	    	    
	    return mav;
	     }
	//-------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/emihistory", method = RequestMethod.GET)
	  public ModelAndView getUserEmiHistory(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    ModelAndView mav = new ModelAndView("installHistory");
	    User user =(User)session.getAttribute("user");
	    List<Object[]>  installments = userservice.getUserEmiHistory(user);
	    mav.addObject("installments", installments);
	    
	    System.out.println("Controller called"+installments);
	    return mav;
	     }
	
	//------------------------------------------------------------------------------------------------------------------------//
	
	//showing user history of its installments
	@RequestMapping(value = "/installhistory", method = RequestMethod.GET)
	  public ModelAndView getUserInstallmentHistory(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    ModelAndView mav = new ModelAndView("History");
	    User user =(User)session.getAttribute("user");
	    String emino = request.getParameter("emi_no");
	    System.out.println(emino+"EMI NO");
	    List<Object[]>  installH = userservice.getUserInstallmentHistory(user,emino);
	    mav.addObject("installH", installH);
	    
	    System.out.println("Controller called"+installH);
	    return mav;
	     }
	
}
