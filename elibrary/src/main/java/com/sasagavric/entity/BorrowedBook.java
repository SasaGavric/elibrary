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

/**
 * @author Sasa
 *
 */
@Entity
@Table(name = "member_book")
public class BorrowedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
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

	public BorrowedBook() {

	}


	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateOfBorrowing() {
		return dateOfBorrowing;
	}


	public void setDateOfBorrowing(Date dateOfBorrowing) {
		this.dateOfBorrowing = dateOfBorrowing;
	}

	

}
