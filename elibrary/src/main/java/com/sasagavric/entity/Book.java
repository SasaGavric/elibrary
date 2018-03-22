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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sasa Gavric
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 2, max = 70)
	@Value("${foo.firstName}")
	private String title;
	
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

}
