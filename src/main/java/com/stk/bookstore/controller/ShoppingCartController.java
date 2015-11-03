package com.stk.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
	
	@RequestMapping(value="/addtocart/{id}", method=RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable Integer id){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

}
