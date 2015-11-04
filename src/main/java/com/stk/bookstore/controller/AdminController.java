package com.stk.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.bookstore.service.BookstoreService;

@Controller
public class AdminController {
	
	@Autowired
	BookstoreService bookstoreService;
	
	/**
	 * Shows the admin control panel page.
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	public ModelAndView showAdminPage(){
		ModelAndView model = new ModelAndView();
		model.addObject("books",bookstoreService.getAllBooks());
		model.setViewName("admin");
		return model;
	}

}
