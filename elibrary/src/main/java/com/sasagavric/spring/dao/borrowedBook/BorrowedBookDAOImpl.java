package com.sasagavric.spring.dao.borrowedBook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sasagavric.entity.BorrowedBook;
import com.sasagavric.entity.Member;

/**
 * @author Sasa Gavric
 *
 */
@Repository
public class BorrowedBookDAOImpl implements BorrowedBookDAO {
	
	private SessionFactory factory;
	
	@Autowired
	public BorrowedBookDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	/* borrow one book
	 * @see
	 * com.sasagavric.spring.dao.borrowedBook.BorrowedBookDAO#borrowOneBook(com.
	 * sasagavric.entity.BorrowedBook)
	 */
	@Override
	public void borrowOneBook(BorrowedBook theBorrowedBook) {
		Session session = factory.getCurrentSession();

		session.save(theBorrowedBook);

		@SuppressWarnings("unchecked")
		Query<Member> query = session
				.createQuery("update Book book set book.booksInStock=book.booksInStock -1 where book.id=:bookId");

		query.setParameter("bookId", theBorrowedBook.getBorrowedBook().getId());

		query.executeUpdate();
	}

	/* return one book via BorrowedBook id
	 * @see
	 * com.sasagavric.spring.dao.borrowedBook.BorrowedBookDAO#returnBorrowedBook(
	 * int)
	 */
	@Override
	public void returnBorrowedBook(int borrowedBookId, int bookId) {

		Session session = factory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<Member> deleteBorrowedBookQuery = session.createQuery("delete from BorrowedBook bb where bb.id=:bbId");
		
		@SuppressWarnings("unchecked")
		Query<Member> addBookToStockQuery = session
				.createQuery("update Book book set book.booksInStock=book.booksInStock +1 where book.id=:bookId");

		deleteBorrowedBookQuery.setParameter("bbId", borrowedBookId);
		addBookToStockQuery.setParameter("bookId", bookId);

		deleteBorrowedBookQuery.executeUpdate();
		addBookToStockQuery.executeUpdate();

	}
}
