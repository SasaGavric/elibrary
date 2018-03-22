package com.sasagavric.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sasa
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "member_book")
public class BorrowedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
    @JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne
    @JoinColumn(name = "book_id")
	private Book borrowedBook;
	
	@Column(name="date_of_borrowing")
	@Temporal(TemporalType.DATE)
	private Date dateOfBorrowing;

}
