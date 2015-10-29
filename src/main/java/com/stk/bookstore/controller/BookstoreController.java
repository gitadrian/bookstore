package com.stk.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.bookstore.model.CategoryEntity;
import com.stk.bookstore.repository.BookstoreRepository;
import com.stk.bookstore.service.BookstoreService;

@Controller
public class BookstoreController {
	
	@Autowired
	BookstoreService bookstoreService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.addObject("books",bookstoreService.getAllBooks());
		model.addObject("categories", bookstoreService.getAllCategories());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
	public ModelAndView showBooksByCategory(@PathVariable String category) {

		ModelAndView model = new ModelAndView();
		model.addObject("categories", bookstoreService.getAllCategories());
		model.addObject("books", bookstoreService.getBooksByCategoryName(category));
		model.setViewName("category");
		return model;
	}

}
