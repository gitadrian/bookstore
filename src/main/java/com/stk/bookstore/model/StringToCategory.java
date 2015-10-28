package com.stk.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


import org.springframework.stereotype.Component;

import com.stk.bookstore.repository.BookstoreRepository;

@Component
public class StringToCategory implements Converter <String, CategoryEntity>{

	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	public CategoryEntity convert(String id) {
		return bookstoreRepository.findCategoryById(Integer.parseInt(id));
	}

	

}
