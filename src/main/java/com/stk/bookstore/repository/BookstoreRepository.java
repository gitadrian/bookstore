package com.stk.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stk.bookstore.model.BookEntity;
import com.stk.bookstore.model.CartEntity;
import com.stk.bookstore.model.CartLineEntity;
import com.stk.bookstore.model.CategoryEntity;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class BookstoreRepository {

	@PersistenceContext(unitName = "movie-rental")
	private EntityManager em;

	/**
	 * Finds all books.
	 * @return
	 */
	public List<BookEntity> findAllBooks(){
		return em.createNativeQuery("SELECT * FROM BOOK",BookEntity.class).getResultList();
	}
	
	/**
	 * Finds a book that matches the given book ID.
	 * @param id
	 * @return
	 */
	
	public BookEntity findBookById(Integer id){
		return (BookEntity) em.createNativeQuery("SELECT * FROM BOOK where book_id=:id", BookEntity.class).setParameter("id", id).getSingleResult();
	}
	
	/**
	 * Finds books by their category name.
	 * @param category
	 * @return
	 */
	
	public List<BookEntity> findBooksByCategoryName(String category){
		return em.createNativeQuery("SELECT * FROM BOOK JOIN CATEGORY ON book.category_id = category.category_id WHERE category.name =:category", BookEntity.class).setParameter("category", category).getResultList();
	}
	
	/**
	 * Finds all categories.
	 * @return
	 */
	
	public List<CategoryEntity> findAllCategories() {
		return em.createNativeQuery("SELECT * FROM CATEGORY", CategoryEntity.class).getResultList();

	}
	
	/**
	 * Finds the category that matches the given category ID.
	 * @param id
	 * @return
	 */
	
	public CategoryEntity findCategoryById(Integer id){
		return (CategoryEntity) em.createNativeQuery("SELECT * FROM CATEGORY WHERE category_id=:id", CategoryEntity.class).setParameter("id",id).getSingleResult();
	}
	
	/**
	 * Inserts a book into the database
	 * @param bookEntity
	 */

	public void save(BookEntity bookEntity) {
		
		em.persist(bookEntity);
	}
	
	/**
	 * Deletes a book from the database.
	 * @param id
	 */
	
	public void deleteBook(Integer id){
		em.remove(em.find(BookEntity.class, id));
		
	}
	
	/**
	 * Updates the price of a book.
	 * @param newPrice
	 * @param id
	 */
	public void updateBook(Float newPrice, Integer id){
		em.createNativeQuery("UPDATE BOOK SET price =? where book_id =?").setParameter(1, newPrice).setParameter(2, id).executeUpdate();
	}
	
	public CartEntity getCartIdByUsername(String currentUser){
  		return (CartEntity)em.createNativeQuery("SELECT * FROM CART WHERE username=:currentUser",CartEntity.class).setParameter("currentUser", currentUser).getSingleResult();

	}
	
	public void addBookToCart(CartEntity cartEntity, BookEntity book){
		Float line_amount = book.getPrice();
		Integer book_id = book.getBook_id();
		Integer cart_id = cartEntity.getCart_id();
		em.createNativeQuery("INSERT INTO CART_LINE(cart_id, line_amount, book_id) values(:cart_id, :line_amount, :book_id)").setParameter("cart_id", cart_id).setParameter("line_amount", line_amount).setParameter("book_id", book_id).executeUpdate();
	}
	
	public List<CartLineEntity> getCartLinesByUsername(String currentUser){
		CartEntity cart_id = getCartIdByUsername(currentUser);
		return (List<CartLineEntity>)em.createNativeQuery("SELECT * FROM CART_LINE WHERE cart_id=:cart_id").setParameter("cart_id", cart_id).getResultList();
	}
	

}
