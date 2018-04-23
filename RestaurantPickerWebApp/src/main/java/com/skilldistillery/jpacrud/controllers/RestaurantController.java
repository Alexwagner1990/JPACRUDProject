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
import com.skilldistillery.jpacrud.data.UserDAO;
import com.skilldistillery.jpacrud.data.UserDAOImpl;
import com.skilldistillery.jpacrud.entities.Restaurant;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantDAO dao;
	
	private UserDAO udao = new UserDAOImpl();

	@RequestMapping(path = "index.do", method = RequestMethod.POST)
	public ModelAndView indexP() {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> fullList = dao.allRestaurants();
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}
	
	@RequestMapping(path = "index.do", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> fullList = dao.allRestaurants();
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}

	@RequestMapping(path = "addrestPage.do", method = RequestMethod.POST)
	public ModelAndView goToAddPage(@RequestParam(name = "restNums") int number) {
		ModelAndView mv = new ModelAndView();
		List<Object> forms = new ArrayList<>();
			for (int i = 0; i < number; i++) {
				forms.add(new Object());
			}
			mv.setViewName("WEB-INF/views/addrest.jsp");
			mv.addObject("RestNumber", forms);
			return mv;
	}
	
	@RequestMapping(path="quickadd.do", method = RequestMethod.POST)
	public String goToQuickAdd() {
		return "WEB-INF/views/quickadd.jsp";
	}

	@RequestMapping(path = "addrest.do", method = RequestMethod.POST)
	public ModelAndView addRestToDB(Restaurant restaurant) {
		ModelAndView mv = new ModelAndView();
		Boolean confirm = dao.addRestaurant(restaurant);
		mv.addObject("confirm", confirm);
		mv.setViewName("WEB-INF/views/addrestConfirm.jsp");
		return mv;
	}
	
	@RequestMapping(path="addLotsRest.do", method= RequestMethod.POST)
	public ModelAndView addLotsOfRestToDB(@RequestParam(name="name[]")String[] names) {
		System.out.println(names);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/addrestConfirm.jsp");
		Boolean check = dao.addManyRestaurants(names);
		mv.addObject("confirm", check);
		return mv;
	}

	@RequestMapping(path = "pickrandom.do", method = RequestMethod.POST)
	public ModelAndView pickRandom() {
		ModelAndView mv = new ModelAndView();
		Restaurant rest = dao.pickRandomRestaurant();
		if(rest !=null) {
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		mv.addObject("restaurant", rest);
		}
		else {
			mv.setViewName("WEB-INF/views/index.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path="pickfavorite.do", method=RequestMethod.POST)
	public ModelAndView pickFavorite() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomFavoriteRestaurant();
		if(picked == null) {
			mv.setViewName("WEB-INF/views/nofavorite.jsp");
		}
		mv.addObject("restaurant", picked);
		return mv;
	}

	@RequestMapping(path = "findrest.do", method = RequestMethod.POST)
	public ModelAndView findRestaurants(@RequestParam(name="searchTerm")String searchTerm) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> rest = dao.viewRestaurantInformation(searchTerm);
		if(rest.size() !=0) {
		Restaurant restaurant = rest.get(0);
		mv.addObject("searchTerm", restaurant);
		mv.setViewName("WEB-INF/views/viewingRestaurants.jsp");
		}
		else {
		mv.addObject("searchTerm", null);
		mv.setViewName("WEB-INF/views/viewingRestaurants.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "updatePage.do", method = RequestMethod.POST)
	public ModelAndView goToTheUpdatePageWithCorrectRestaurant(@RequestParam(name = "id") int id) {
		ModelAndView mv = new ModelAndView();
		Restaurant restaurant = dao.findRestaurantById(id);
		mv.addObject("restaurant", restaurant);
		mv.setViewName("WEB-INF/views/update.jsp");
		return mv;
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updateARestaurant(Restaurant restaurant, @RequestParam(name = "id") int id) {
		ModelAndView mv = new ModelAndView();
		Restaurant restr = dao.updateRestaurant(restaurant, id);
		mv.setViewName("WEB-INF/views/update.jsp");
		mv.addObject("restaurant", restr);
		return mv;
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteingARestaurant(@RequestParam(name = "id") int id) {
		ModelAndView mv = new ModelAndView();
		Boolean deleted = dao.deleteRestaurant(id);
		mv.addObject("deleted", deleted);
		mv.setViewName("WEB-INF/views/deleterest.jsp");
		return mv;
	}
	
	@RequestMapping(path = "findrestList.do", method = RequestMethod.POST)
	public ModelAndView directingToRestaurantListPages(@RequestParam(name="type") String type) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> blankobject = null;
		mv.addObject("restList", blankobject);
		if(type.equals("cat")) {
			mv.setViewName("WEB-INF/views/listAllByCat.jsp");
		}
		if(type.equals("distance")) {
			mv.setViewName("WEB-INF/views/listAllByDistance.jsp");
		}
		if(type.equals("price")){
			mv.setViewName("WEB-INF/views/listAllByPrice.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path= "findCategory.do", method= RequestMethod.POST)
	public ModelAndView showAllOfACategory(@RequestParam(name="category") String category) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByCat.jsp");
		List<Restaurant> results = dao.getRestaurantsOfCategory(category);
		mv.addObject("restList", results);
		mv.addObject("choice", category);
		return mv;
	}
	
	@RequestMapping(path= "findPrice.do", method= RequestMethod.POST)
	public ModelAndView showAllOfAPrice(@RequestParam(name="price") String price) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByPrice.jsp");
		List<Restaurant> results = dao.getRestaurantsOfPrice(price);
		mv.addObject("restList", results);
		mv.addObject("choice", price);
		return mv;
	}
	
	@RequestMapping(path= "findDistance.do", method= RequestMethod.POST)
	public ModelAndView showAllOfADistance(@RequestParam(name="distance") String distance) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByDistance.jsp");
		List<Restaurant> results = dao.getRestaurantsOfDistance(distance);
		mv.addObject("restList", results);
		mv.addObject("choice", distance);
		return mv;
	}
	
	@RequestMapping(path="randomCat.do", method=RequestMethod.POST)
	public ModelAndView pickRandomRestByCat(@RequestParam(name="choice") String choice) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfCategory(choice);
		mv.addObject(picked);
		return mv;
	}
	
	@RequestMapping(path="randomPrice.do", method=RequestMethod.POST)
	public ModelAndView pickRandomRestByPrice(@RequestParam(name="choice") String choice) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfPrice(choice);
		mv.addObject(picked);
		return mv;
	}
	
	@RequestMapping(path="randomDistance.do", method=RequestMethod.POST)
	public ModelAndView pickRandomRestByDistance(@RequestParam(name="choice") String choice) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfDistance(choice);
		mv.addObject(picked);
		return mv;
	}
	
//	@RequestMapping(path="loginPage.do", method=RequestMethod.GET)
//	public ModelAndView goToLoginPage(@RequestParam(name="test")String test) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("WEB-INF/views/login.jsp");
//		mv.addObject("user", new User());
//		return mv;
//	}
	
	
}
