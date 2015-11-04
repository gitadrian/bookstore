package com.stk.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	private Integer cart_id;
	
	@Column(columnDefinition = "INTEGER")
	private Integer cart_amount;
	
	@OneToOne
	private UsersEntity username;

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public Integer getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(Integer cart_amount) {
		this.cart_amount = cart_amount;
	}

	public UsersEntity getUser() {
		return username;
	}

	public void setUser(UsersEntity user) {
		this.username = user;
	}

	@Override
	public String toString() {
		return "CartEntity [cart_id=" + cart_id + ", cart_amount="
				+ cart_amount + ", user=" + username + "]";
	}

	
	
	
	

}
