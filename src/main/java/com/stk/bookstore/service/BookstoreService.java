package com.stk.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stk.bookstore.model.BookEntity;
import com.stk.bookstore.model.CategoryEntity;
import com.stk.bookstore.repository.BookstoreRepository;

@Component
public class BookstoreService {
	
	@Autowired
	BookstoreRepository bookstoreRepository;
	
	public void add(BookEntity bookEntity){
		bookstoreRepository.save(bookEntity);
	}
	
	public List<BookEntity> getAllBooks(){
		return bookstoreRepository.findAllBooks();
	}
	
	public List<BookEntity> getBooksByCategoryName(String category){
		return bookstoreRepository.findBooksByCategoryName(category);
	}
	
	public BookEntity getBookById(Integer id){
		return bookstoreRepository.findBookById(id);
	}
	
	public List<CategoryEntity> getAllCategories(){
		return bookstoreRepository.findAllCategories();
	}
	
	public CategoryEntity getCategoryById(Integer id){
		return bookstoreRepository.findCategoryById(id);
	}
	
	public void removeBook(Integer id){
		bookstoreRepository.deleteBook(id);
	}
	
	
}
