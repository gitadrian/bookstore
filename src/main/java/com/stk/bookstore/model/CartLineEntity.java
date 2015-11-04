package com.stk.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CART_LINE")
public class CartLineEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	private Integer cart_line_id;
	
	@ManyToOne
	private CartEntity cart_id;
	
	@Column(columnDefinition = "FLOAT")
	private Float line_amount;
	
	@ManyToOne
	private BookEntity book_id;

	public Integer getCart_line_id() {
		return cart_line_id;
	}

	public void setCart_line_id(Integer cart_line_id) {
		this.cart_line_id = cart_line_id;
	}

	public CartEntity getCart_id() {
		return cart_id;
	}

	public void setCart_id(CartEntity cart_id) {
		this.cart_id = cart_id;
	}

	public Float getLine_amount() {
		return line_amount;
	}

	public void setLine_amount(Float line_amount) {
		this.line_amount = line_amount;
	}

	public BookEntity getBook_id() {
		return book_id;
	}

	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}

	@Override
	public String toString() {
		return "CartLineEntity [cart_line_id=" + cart_line_id + ", cart_id="
				+ cart_id + ", line_amount=" + line_amount + ", book_id="
				+ book_id + "]";
	}
	
	

}
