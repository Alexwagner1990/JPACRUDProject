package com.skilldistillery.jpacrud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrud.data.RestaurantDAO;
import com.skilldistillery.jpacrud.data.UserDAO;
import com.skilldistillery.jpacrud.data.UserDAOImpl;
import com.skilldistillery.jpacrud.entities.Restaurant;
import com.skilldistillery.jpacrud.entities.User;

@Controller
@SessionAttributes("user")
public class RestaurantController {

	@Autowired
	private RestaurantDAO dao;

	private UserDAO udao = new UserDAOImpl();

	// THIS IS PROBABLY WRONG REMOVE EVENTUALLY - WAIT WHY DOES THIS WORK THAT'S
	// UNEXPECTED KINDA
	@ModelAttribute("user")
	public User initValidUser(@ModelAttribute("user") User user) {
		if (user == null) {
			user = new User();
		}
		if (user.getRestaurants() == null || user.getRestaurants().size() == 0) {
			user.setRestaurants(new ArrayList<>());
		}
//		user.setRestaurants(user.getRestaurants()); // THIS MAY BREAK EVERYTHING
		return user;
	}

	@RequestMapping(path = "index.do", method = RequestMethod.POST)
	public ModelAndView indexP(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> fullList = dao.allRestaurants(user);
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}

	@RequestMapping(path = "index.do", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> fullList = dao.allRestaurants(user);
		mv.setViewName("WEB-INF/views/index.jsp");
		mv.addObject("fullList", fullList);
		return mv;
	}

	@RequestMapping(path = "addrestPage.do", method = RequestMethod.POST)
	public ModelAndView goToAddPage(@RequestParam(name = "restNums") int number, @ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Object> forms = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			forms.add(new Object());
		}
		mv.setViewName("WEB-INF/views/addrest.jsp");
		mv.addObject("RestNumber", forms);
		return mv;
	}

	@RequestMapping(path = "quickadd.do", method = RequestMethod.POST)
	public ModelAndView goToQuickAdd(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/quickadd.jsp");
		return mv;
	}

	@RequestMapping(path = "addrest.do", method = RequestMethod.POST)
	public ModelAndView addRestToDB(Restaurant restaurant, @ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		Boolean confirm = dao.addRestaurant(restaurant, user);
		if (confirm) {
			user.addRestaurants(restaurant); // THIS MIGHT BREAK EVERYTHING
		}
		mv.addObject("confirm", confirm);
		mv.setViewName("WEB-INF/views/addrestConfirm.jsp");
		return mv;
	}

	@RequestMapping(path = "addLotsRest.do", method = RequestMethod.POST)
	public ModelAndView addLotsOfRestToDB(@RequestParam(name = "name[]") String[] names,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/addrestConfirm.jsp");
		Boolean check = dao.addManyRestaurants(names, user);
		if (check) { //THIS MIGHT BREAK EVERYTHING
			for (int i = 0; i < names.length; i++) {
				user.addRestaurants(new Restaurant(names[i], user, 0));

			}
		}
		mv.addObject("confirm", check);
		return mv;
	}

	@RequestMapping(path = "pickrandom.do", method = RequestMethod.POST)
	public ModelAndView pickRandom(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		Restaurant rest = dao.pickRandomRestaurant(user);
		if (rest != null) {
			mv.setViewName("WEB-INF/views/pickrest.jsp");
			mv.addObject("restaurant", rest);
		} else {
			mv.setViewName("WEB-INF/views/norestaurants.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "pickfavorite.do", method = RequestMethod.POST)
	public ModelAndView pickFavorite(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomFavoriteRestaurant(user);
		if (picked == null) {
			mv.setViewName("WEB-INF/views/nofavorite.jsp");
		}
		mv.addObject("restaurant", picked);
		return mv;
	}

	@RequestMapping(path = "findrest.do", method = RequestMethod.POST)
	public ModelAndView findRestaurants(@RequestParam(name = "searchTerm") String searchTerm,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> rest = dao.viewRestaurantInformation(searchTerm, user);
		if (rest.size() != 0) {
			mv.addObject("searchTerm", rest);
			mv.setViewName("WEB-INF/views/viewingRestaurants.jsp");
		} else {
			mv.addObject("searchTerm", null);
			mv.setViewName("WEB-INF/views/viewingRestaurants.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "updatePage.do", method = RequestMethod.POST)
	public ModelAndView goToTheUpdatePageWithCorrectRestaurant(@RequestParam(name = "id") int id,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		Restaurant restaurant = dao.findRestaurantById(id);
		mv.addObject("restaurant", restaurant);
		mv.setViewName("WEB-INF/views/update.jsp");
		return mv;
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updateARestaurant(Restaurant restaurant, @RequestParam(name = "id") int id,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		Restaurant restr = dao.updateRestaurant(restaurant, id, user);
		mv.setViewName("WEB-INF/views/update.jsp");
		mv.addObject("restaurant", restr);
		return mv;
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteingARestaurant(@RequestParam(name = "id") int id, @ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		Restaurant restaurant = dao.findRestaurantById(id);
		Boolean deleted = dao.deleteRestaurant(id);
		if (deleted) {
			user.removeRestaurants(restaurant); // THIS MIGHT BREAK EVERYTHING
		}
		mv.addObject("deleted", deleted);
		mv.setViewName("WEB-INF/views/deleterest.jsp");
		return mv;
	}

	@RequestMapping(path = "findrestList.do", method = RequestMethod.POST)
	public ModelAndView directingToRestaurantListPages(@RequestParam(name = "type") String type,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Restaurant> blankobject = null;
		mv.addObject("restList", blankobject);
		if (type.equals("cat")) {
			mv.setViewName("WEB-INF/views/listAllByCat.jsp");
		}
		if (type.equals("distance")) {
			mv.setViewName("WEB-INF/views/listAllByDistance.jsp");
		}
		if (type.equals("price")) {
			mv.setViewName("WEB-INF/views/listAllByPrice.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "findCategory.do", method = RequestMethod.POST)
	public ModelAndView showAllOfACategory(@RequestParam(name = "category") String category,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByCat.jsp");
		List<Restaurant> results = dao.getRestaurantsOfCategory(category, user);
		mv.addObject("restList", results);
		mv.addObject("choice", category);
		return mv;
	}

	@RequestMapping(path = "findPrice.do", method = RequestMethod.POST)
	public ModelAndView showAllOfAPrice(@RequestParam(name = "price") String price, @ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByPrice.jsp");
		List<Restaurant> results = dao.getRestaurantsOfPrice(price, user);
		mv.addObject("restList", results);
		mv.addObject("choice", price);
		return mv;
	}

	@RequestMapping(path = "findDistance.do", method = RequestMethod.POST)
	public ModelAndView showAllOfADistance(@RequestParam(name = "distance") String distance,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/listAllByDistance.jsp");
		List<Restaurant> results = dao.getRestaurantsOfDistance(distance, user);
		mv.addObject("restList", results);
		mv.addObject("choice", distance);
		return mv;
	}

	@RequestMapping(path = "randomCat.do", method = RequestMethod.POST)
	public ModelAndView pickRandomRestByCat(@RequestParam(name = "choice") String choice,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfCategory(choice, user);
		mv.addObject(picked);
		return mv;
	}

	@RequestMapping(path = "randomPrice.do", method = RequestMethod.POST)
	public ModelAndView pickRandomRestByPrice(@RequestParam(name = "choice") String choice,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfPrice(choice, user);
		mv.addObject(picked);
		return mv;
	}

	@RequestMapping(path = "randomDistance.do", method = RequestMethod.POST)
	public ModelAndView pickRandomRestByDistance(@RequestParam(name = "choice") String choice,
			@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/pickrest.jsp");
		Restaurant picked = dao.pickRandomRestaurantOfDistance(choice, user);
		mv.addObject(picked);
		return mv;
	}
	

	// @RequestMapping(path="loginPage.do", method=RequestMethod.GET)
	// public ModelAndView goToLoginPage(@RequestParam(name="test")String test) {
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("WEB-INF/views/login.jsp");
	// mv.addObject("user", new User());
	// return mv;
	// }

}
