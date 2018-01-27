package com.sasagavric.spring.dao.book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sasagavric.spring.entity.Book;

/**
 * @author Sasa Gavric
 *
 */
@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory factory;

	
	/* 
	 * This method will load all books from data base
	 * @see com.sasagavric.spring.dao.book.BookDAO#getListOfBooks()
	 */
	@Override
	public List<Book> getListOfBooks() {
		
		Session session = factory.getCurrentSession();
		
		
		@SuppressWarnings("unchecked")
		List<Book> listOfBooks = session.createQuery("from Book").getResultList();
		
		return listOfBooks;
	}

	/* This method will found one book via book id
	 * @see com.sasagavric.spring.dao.book.BookDAO#getBook(int)
	 */
	@Override
	public Book getBook(int theId) {
		
		Session session = factory.getCurrentSession();
		
		Book theBook = session.get(Book.class, theId);
		
		return theBook;
	}

	/* This method will search for list of books via book title
	 * @see com.sasagavric.spring.dao.book.BookDAO#searchFoBook(java.lang.String)
	 */
	@Override
	public List<Book> searchFoBook(String bookTitle) {
		
		Session session = factory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Book> theQuery = session.createQuery("from Book b where b.title LIKE CONCAT('%',?1,'%')");
		
		theQuery.setParameter(1, bookTitle);
		
		List<Book> theListOfBooks = theQuery.getResultList();
		
		return theListOfBooks;
	}

	/* This method will delete book form data base via book identifier
	 * @see com.sasagavric.spring.dao.book.BookDAO#deleteBook(com.sasagavric.spring.entity.Book)
	 */
	@Override
	public void deleteBook(Book theBook) {
		
		Session theSession = factory.getCurrentSession();
		theSession.delete(theBook);
		
	}
	
	

}