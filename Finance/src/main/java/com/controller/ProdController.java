package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Products;
import com.service.UserService;
import com.service.UserServiceImpl;

@Controller("prodController")
public class ProdController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/viewProducts",method=RequestMethod.GET)
	public ModelAndView getUsers(){
		System.out.println("Controller called");
		List<Products> plist = userservice.getAllProducts();
		System.out.println(plist);
		ModelAndView mav = new ModelAndView("viewProducts");
		mav.addObject("plist", plist);
		return mav;
	
	}
}
