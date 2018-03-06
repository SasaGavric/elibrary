package com.sasagavric.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Sasa Gavric
 *
 */
@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	@NotNull
	@Size(min = 2, max = 70)
	@Value("${foo.firstName}")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_issue")
	@DateTimeFormat(iso= ISO.DATE)
	@NotNull
	@Past
	private Date dateOfIssue;
	
	@Column(name="number_of_pages")
	@NotNull
	@Min(1)
	@Max(50000)
	private int numberOfPages;
	
	@Column(name="language")
	@NotNull
	@Size(min = 2, max = 35)
	private String language;
	
	@Column(name="image_url")
	@Size(min=1, max=2082)
	private String coverImageUrl;
	
	@NotNull
	@Min(0)
	@Max(50000)
	@Column(name="book_in_stock")
	private int booksInStock;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name="book_author",
			joinColumns=@JoinColumn(name="book_id"),
			inverseJoinColumns=@JoinColumn(name="author_id")
			)
	private List<Author> listOfAuthors;
	
	public Book() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public List<Author> getListOfAuthors() {
		return listOfAuthors;
	}

	public void setListOfAuthors(List<Author> listOfAuthors) {
		this.listOfAuthors = listOfAuthors;
	}

	public int getBooksInStock() {
		return booksInStock;
	}

	public void setBooksInStock(int booksInStock) {
		this.booksInStock = booksInStock;
	}
	
	
	
	
	
}
