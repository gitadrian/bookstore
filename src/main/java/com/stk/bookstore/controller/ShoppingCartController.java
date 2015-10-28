package com.stk.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
	
	@RequestMapping(value="/addtocart", method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("id") int id){
		ModelAndView model = new ModelAndView();
		System.out.println(id);
		return model;
	}

}
