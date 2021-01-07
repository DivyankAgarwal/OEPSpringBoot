package com.vwits.OEP.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.OEP.dao.UserDAO;
import com.vwits.OEP.model.Users;

@Controller
public class RegisterController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role) {
		Users newUser = new Users();
		
		newUser.setEmpid(id);
		newUser.setName(name);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setRole(role);
		if(newUser.getRole().equals("student"))
			newUser.setEnabled("N");
		else
			newUser.setEnabled("Y");
		System.out.println(newUser);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome.jsp");
		mv.addObject("data",newUser);
		
		userDAO.registerUser(newUser);
		return mv;
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,int id) {
//		
//		ModelAndView model = new ModelAndView();
//		
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String username = request.getParameter("username");
//		String role = request.getParameter("role");
//		
//		Users newUser = new Users();
//		newUser.setEmpid(id);
//		newUser.setName(name);
//		newUser.setUsername(username);
//		newUser.setPassword(password);
//		newUser.setRole(role);
//		if(role.equals("student"))
//			newUser.setEnabled("F");
//		else
//			newUser.setEnabled("T");
//		System.out.println(newUser);
//		userDAO.registerUser(newUser);
//		
//		model.setViewName("welcome.jsp");
//		model.addObject("data",newUser);
//		
//		return model;
//	}

}
