package com.sasagavric.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name="book_author",
			joinColumns=@JoinColumn(name="author_id"),
			inverseJoinColumns=@JoinColumn(name="book_id")
			)
	private List<Book> listOfIssuedBooks;
	
	//default constructor
	public Author() {
		
	}

	//accessors and mutators
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getListOfIssuedBooks() {
		return listOfIssuedBooks;
	}

	public void setListOfIssuedBooks(List<Book> listOfIssuedBooks) {
		this.listOfIssuedBooks = listOfIssuedBooks;
	}
	
	
	
	
}
