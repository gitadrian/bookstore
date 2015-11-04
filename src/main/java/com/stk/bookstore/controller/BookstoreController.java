package com.stk.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	/**
	 * Shows the index page containing all the books in the database.
	 * @return
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.addObject("books",bookstoreService.getAllBooks());
		model.addObject("categories", bookstoreService.getAllCategories());
  		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
  		model.addObject("user", currentUser);
		model.setViewName("index");
		return model;
	}
	
	/**
	 * Sorts books by category
	 * @param category
	 * @return
	 */
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
	public ModelAndView showBooksByCategory(@PathVariable String category) {

		ModelAndView model = new ModelAndView();
		model.addObject("categories", bookstoreService.getAllCategories());
		model.addObject("books", bookstoreService.getBooksByCategoryName(category));
		model.setViewName("category");
		return model;
	}
	
	/**
	 * Shows the details of the selected book.
	 * @param id
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/bookdetails/{id}")
	public ModelAndView showBookDetails(@PathVariable Integer id) {

		ModelAndView model = new ModelAndView();
		model.addObject("books", bookstoreService.getBookById(id));
		model.setViewName("details");
		return model;
	}
	
	/**
	 * Deletes the selected book.
	 * @param id
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String deleteBook(@PathVariable Integer id){
		bookstoreService.removeBook(id);
		return "index";
	}
	
	/**
	 * Shows a page where the user can edit the price of the selected book.
	 * @param id
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public ModelAndView showUpdatePricePage (@PathVariable Integer id){
		ModelAndView model = new ModelAndView();
		model.addObject("book1", bookstoreService.getBookById(id));
		System.out.println(bookstoreService.getBookById(id));
		model.setViewName("update");
		return model;
	}
	
	/**
	 * Edits the price of the selected book.
	 * @param book1
	 * @return
	 */
	
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
