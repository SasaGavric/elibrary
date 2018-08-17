package com.sasagavric.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Sasa Gavric
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class Author extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(
			name = "book_author", 
			joinColumns = @JoinColumn(name = "author_id"), 
			inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> listOfIssuedBooks;


	@Override
	public String toString() {
		return this.getFirstName() + "  " + this.getLastName();
	}

}
