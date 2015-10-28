package com.stk.bookstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", columnDefinition = "INTEGER")
	private Integer book_id;

	@Column(name = "title", columnDefinition = "VARCHAR(45)")
	private String title;

	@Column(name = "year", columnDefinition = "INTEGER")
	private Integer year;

	@Column(name = "publisher", columnDefinition = "VARCHAR(45)")
	private String publisher;

	@OneToOne(cascade = CascadeType.MERGE)
	private CategoryEntity category_Id;

	@Column(name = "price", columnDefinition = "FLOAT")
	private Float price;

	@Column(name = "quantity", columnDefinition = "INTEGER")
	private Integer quantity;

	@Column(name = "description", columnDefinition = "VARCHAR(400)")
	private String description;

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public CategoryEntity getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(CategoryEntity category_Id) {
		this.category_Id = category_Id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookEntity [book_id=" + book_id + ", title=" + title
				+ ", year=" + year + ", publisher=" + publisher
				+ ", category_Id=" + category_Id + ", price=" + price
				+ ", quantity=" + quantity + ", description=" + description
				+ "]";
	}

}
