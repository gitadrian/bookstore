package com.stk.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stk.bookstore.model.BookEntity;
import com.stk.bookstore.model.CategoryEntity;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class BookstoreRepository {

	@PersistenceContext(unitName = "movie-rental")
	private EntityManager em;

	
	public List<BookEntity> findAllBooks(){
		return em.createNativeQuery("SELECT * FROM BOOK",BookEntity.class).getResultList();
	}
	
	public BookEntity findBookById(Integer id){
		return (BookEntity) em.createNativeQuery("SELECT * FROM BOOK where book_id=:id", BookEntity.class).setParameter("id", id).getSingleResult();
	}
	
	public List<BookEntity> findBooksByCategoryName(String category){
		return em.createNativeQuery("SELECT * FROM BOOK JOIN CATEGORY ON book.category_id = category.category_id WHERE category.name =:category", BookEntity.class).setParameter("category", category).getResultList();
	}
	
	public List<CategoryEntity> findAllCategories() {
		return em.createNativeQuery("SELECT * FROM CATEGORY", CategoryEntity.class).getResultList();

	}
	
	public CategoryEntity findCategoryById(Integer id){
		return (CategoryEntity) em.createNativeQuery("SELECT * FROM CATEGORY WHERE category_id=:id", CategoryEntity.class).setParameter("id",id).getSingleResult();
	}

	public void save(BookEntity bookEntity) {
		
		em.persist(bookEntity);
	}
	
	public void deleteBook(Integer id){
		em.remove(em.find(BookEntity.class, id));
		
	}
	
	public void updatePrice(){
		
	}

}
