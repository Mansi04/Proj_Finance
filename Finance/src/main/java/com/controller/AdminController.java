package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Admin;
import com.model.User;
import com.model.Users;
import com.service.AdminServiceIntf;

@Controller("mycontroller1")
public class AdminController {

	@Autowired
	AdminServiceIntf adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("loginadmin");
	    mav.addObject("admin", new Admin());
	    return mav;
	     }
	 @RequestMapping(value = "/adminProcess", method = RequestMethod.POST)
	  public ModelAndView adminProcess( @ModelAttribute Admin admin, HttpSession session) {	 
		 System.out.println(admin.getUsername()+"\n"+admin.getPassword());    
	     boolean flag = adminService.validateAdmin(admin);
	     ModelAndView mav = new ModelAndView();
	     if(flag) {
	    	 mav.addObject("status","Login Success");
	    	 session.setAttribute("username", admin.getUsername());
	    	   mav.setViewName("admin_page");     	
	      }
	      else 
	      {	    	  
	    	   	mav.addObject("status","Login Failed");
	    	   	mav.setViewName("loginadmin");
	    	   	return mav;
	      }
	     return mav;
	          
	 }
	 
	 @RequestMapping(value = "/adchngepass", method = RequestMethod.GET)
	  public ModelAndView changepwd1(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("adchngepass");
	    return mav;
	  }
	@RequestMapping(value = "/adchngepass", method = RequestMethod.POST)
	  public ModelAndView changepwd2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
      String username=(String)session.getAttribute("username");
      String opwd= request.getParameter("opassword");
      String npwd= request.getParameter("npassword");
      System.out.println(username+"  "+opwd+"  "+npwd);
      boolean flag = adminService.changepasswrd(username,opwd,npwd);
      if(flag) {
	       ModelAndView mav = new ModelAndView("adchngepass");
	       mav.addObject("message", "Password is successfully updated");
	       return mav;
	  }
      else {
      	ModelAndView mav = new ModelAndView("adchngepass");
		       mav.addObject("message", "Password is not updated");
		       return mav;
      }
	} 
	
	//Getting User details 
	 @RequestMapping(value = "/getApplicant", method = RequestMethod.GET)
	  public ModelAndView getApplicant(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("getApplicant");
	    return mav;
	  }
	
	 @RequestMapping(value = "/getApplicant", method = RequestMethod.POST)
	  public ModelAndView getApplicantDetailsbyId(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 ModelAndView mav = new ModelAndView();
		 String app_id = request.getParameter("app_id");
		 Users ulist = adminService.getApplicantDetailsbyId(app_id);
		 mav.addObject("ulist",ulist);
		 mav.setViewName("viewDetails");
		 return mav;
     }
	 
	//Viewing all Users
		@RequestMapping(value="/viewUser" ,method=RequestMethod.GET )
		public ModelAndView getAllMembers(){
			System.out.println("Controller called");
			List<Users> ulist = adminService.getAllMembers();
			System.out.println(ulist);
			ModelAndView mav = new ModelAndView("admin_page");
			mav.addObject("ulist", ulist);
			return mav;
		}
	 
	 @RequestMapping(path="verify.do", method=RequestMethod.POST)
		public String verifyUser(@RequestParam("app_id") String app_id , @RequestParam("action") String action)
		{
		 	ModelAndView mav = new ModelAndView();
			boolean result = adminService.checkUser(app_id,action);
		
			if(result)
			{
				List<Users> userList = adminService.getAllMembers();
				mav.addObject("userList", userList);
				return "admin_page";
			}
			else
				return "Error";
				
		}
} 
