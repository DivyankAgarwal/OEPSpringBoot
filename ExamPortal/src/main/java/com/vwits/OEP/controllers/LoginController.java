package com.vwits.OEP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.OEP.dao.UserDAO;
import com.vwits.OEP.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role) {
		
		ModelAndView model = new ModelAndView();
		
		Users getUserInfo = userDAO.getUsername(username);
		if(getUserInfo != null) {
			
			if(getUserInfo.getPassword().equals(password) && getUserInfo.getRole().equals(role)) {
				System.out.println("User is registered");
				System.out.println(getUserInfo);
				model.setViewName("studenthome.jsp");
				model.addObject("name",getUserInfo.getName());
			}else {
				System.out.println("Details doesnt match");
				if(!getUserInfo.getRole().equals(role)) {
					System.out.println(getUserInfo.getRole() + " Role: " + role);
					model.addObject("msg","Role Error");
				}else if(!getUserInfo.getPassword().equals(password)) {
					System.out.println(getUserInfo.getPassword() + " Pwd: " + password);
					model.addObject("msg","INVALID");
				}
				model.setViewName("index.jsp");
				
				
			}
			
		} else {
			System.out.println("Error Fetching");
		}
		
		
		return model;
		
	}

}
