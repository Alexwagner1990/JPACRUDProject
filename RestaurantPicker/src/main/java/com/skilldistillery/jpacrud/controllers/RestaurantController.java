package com.skilldistillery.jpacrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrud.data.RestaurantDAOImpl;
import com.skilldistillery.jpacrud.entities.Restaurant;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantDAOImpl dao;
	
	@RequestMapping(path="index.do", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> fullList = dao.allRestaurants();
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}
	
}
