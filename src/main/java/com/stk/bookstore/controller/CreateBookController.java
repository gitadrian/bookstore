package com.stk.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.bookstore.model.BookEntity;
import com.stk.bookstore.model.CategoryEntity;
import com.stk.bookstore.service.BookstoreService;

@Controller
public class CreateBookController {

	@Autowired
	private BookstoreService bookstoreService;

	/**
	 * Shows a form where the user can insert a new book into the database.
	 * @return
	 */
	
	@RequestMapping(value = "/createbook", method = RequestMethod.GET)
	public ModelAndView showCreateBookPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("createbook");
		BookEntity bookEntity = new BookEntity();
		model.addObject("book", bookEntity);
		model.addObject("categories", bookstoreService.getAllCategories());
		return model;
	}
	
	/**
	 * Inserts the book into the database.
	 * @param book
	 * @return
	 */

	@RequestMapping(value = "/createbookaction", method = RequestMethod.POST)
	public ModelAndView createBook(@ModelAttribute("book") BookEntity book) {
		bookstoreService.add(book);
	    ModelAndView model = new ModelAndView();
	    model.addObject("createdbook", bookstoreService.getBookById(book.getBook_id()));
		model.setViewName("createbooksuccess");
		return model;
	}
	
	
	
}
