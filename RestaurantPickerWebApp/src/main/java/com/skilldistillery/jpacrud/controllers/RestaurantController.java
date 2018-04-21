package com.skilldistillery.jpacrud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrud.data.RestaurantDAO;
import com.skilldistillery.jpacrud.entities.Restaurant;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantDAO dao;
	
	@RequestMapping(path="index.do", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		System.out.println("In controller");
		List<Restaurant> fullList = dao.allRestaurants();
		System.out.println("out of allRestaurants");
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}
	
	@RequestMapping(path="addrest.do", method=RequestMethod.POST)
	public ModelAndView addRest(@RequestParam(name="restNums")int number) {
		ModelAndView mv = new ModelAndView();
		List<Object> forms = new ArrayList<>();
		for(int i=0; i < number; i++) {
			forms.add(new Object());
		}
		mv.setViewName("WEB-INF/views/addrest.jsp");
		mv.addObject("RestNumber", forms);
		return mv;
	}
	
	@RequestMapping(path="pickrandom.do", method=RequestMethod.POST)
	public ModelAndView pickRandom() {
		ModelAndView mv = new ModelAndView();
		Restaurant rest = dao.pickRandomRestaurant();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		mv.addObject("restaurant", rest);
		return mv;
	}
	
	@RequestMapping(path="findrest.do", method=RequestMethod.POST)
	public ModelAndView findRestaurants(@RequestParam(name="searchTerm") String search) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> rest = dao.viewRestaurantInformation(search);
		mv.setViewName("WEB-INF/views/viewingRestaurants.jsp");
		mv.addObject("searchTerm", rest);
		return mv;
	}
	@RequestMapping(path="updatePage.do", method=RequestMethod.POST)
	public ModelAndView goToTheUpdatePageWithCorrectRestaurant(@RequestParam(name="id")int id) {
		ModelAndView mv = new ModelAndView();
		Restaurant restaurant = dao.findRestaurantById(id);
		mv.addObject(restaurant);
		mv.setViewName("WEB-INF/views/update.jsp");
		return mv;
	}
	
	@RequestMapping(path="update.do", method=RequestMethod.POST)
	public ModelAndView updateARestaurant(Restaurant restaurant) {
		ModelAndView mv = new ModelAndView();
		Restaurant restr = dao.updateRestaurant(restaurant);
		mv.setViewName("WEB-INF/views/update.jsp");
		mv.addObject("restaurant", restr);
		return mv;
	}
	
	@RequestMapping(path="delete.do", method=RequestMethod.POST)
	public ModelAndView deleteingARestaurant(@RequestParam(name="id") int id) {
		ModelAndView mv = new ModelAndView();
		Boolean deleted = dao.deleteRestaurant(id);
		mv.addObject("deleted", deleted);
		mv.setViewName("WEB-INF/views/deleterest.jsp");
		return mv;
	}
}
