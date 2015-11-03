package com.stk.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.bookstore.model.BookEntity;
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/bookdetails/{id}")
	public ModelAndView showBookDetails(@PathVariable Integer id) {

		ModelAndView model = new ModelAndView();
		model.addObject("books", bookstoreService.getBookById(id));
		model.setViewName("details");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String deleteBook(@PathVariable Integer id){
		bookstoreService.removeBook(id);
		return "index";
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public ModelAndView showUpdatePricePage (@PathVariable Integer id){
		ModelAndView model = new ModelAndView();
		model.addObject("book1", bookstoreService.getBookById(id));
		System.out.println(bookstoreService.getBookById(id));
		model.setViewName("update");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editbook")
	public ModelAndView editBook(@ModelAttribute BookEntity book1){
		System.out.println("book from form: "+book1);
		bookstoreService.editBook(book1.getPrice(), book1.getBook_id());
		ModelAndView model = new ModelAndView();
		model.addObject("book1", book1);
		model.setViewName("admin");
		return model;
		
	}

}
