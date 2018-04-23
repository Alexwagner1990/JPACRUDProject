package com.skilldistillery.jpacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrud.data.UserDAO;
import com.skilldistillery.jpacrud.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO udao;
	
	@RequestMapping(path="loginPage.do", method=RequestMethod.GET)
	public ModelAndView getToLoginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/login.jsp");
		mv.addObject("created", new Integer(2));
		mv.addObject("login", new Integer(0));
		return mv;
	}
	
	@RequestMapping(path="createAccount.do", method=RequestMethod.POST)
	public ModelAndView createUser(@RequestParam(name="create[]")String[] create) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/login.jsp");
		Boolean checkUnique = udao.checkIfUsernameIsUnique(create[0]);
		if(checkUnique) {
			udao.addUserToDatabase(create);
			mv.addObject("created", new Integer(1));
		}
		else {
			mv.addObject("created", new Integer(0));
		}
		return mv;
	}
	
	@RequestMapping(path="loginAsUser.do", method=RequestMethod.POST)
	public ModelAndView loginToApp(@RequestParam(name="login[]")String[] login) {
		ModelAndView mv = new ModelAndView();
		User user = udao.checkUserLoginCredentials(login);
		if(user != null) {
			mv.addObject("user", user);
			mv.setViewName("index.do");
		}
		else {
			mv.addObject("login", new Integer(1));
			mv.setViewName("WEB-INF/views/login.jsp");
		}
		return mv;
	}


}
