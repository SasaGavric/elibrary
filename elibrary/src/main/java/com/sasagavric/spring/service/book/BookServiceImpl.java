package com.sasagavric.spring.service.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sasagavric.entity.Author;
import com.sasagavric.entity.Book;
import com.sasagavric.spring.dao.book.BookDAO;

/**
 * @author Sasa Gavric
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDao;
	
	@Autowired
	public BookServiceImpl(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	@Transactional
	public List<Book> getListOfBooks(int page) {
		//get all books
		return bookDao.getListOfBooks(page);
	}

	@Override
	@Transactional
	public Book getBook(int theId) {		
		// get requested book from data base
		return bookDao.getBook(theId);
	}

	@Override
	@Transactional
	public List<Book> searchForBook(String bookTitle) {
		
		return bookDao.searchFoBook(bookTitle);
	}

	@Override
	@Transactional
	public void deleteBook(Book theBook) {
		
		bookDao.deleteBook(theBook);
		
	}

	@Override
	@Transactional
	public List<Author> getListOfAuthors() {
		
		return bookDao.getListOfAuthors();
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		bookDao.saveBookToDataBase(theBook);
		
	}

	@Override
	@Transactional
	public Author getById(int authorId) {
		
		return bookDao.getAuthor(authorId);
	}

	@Override
	@Transactional
	public void saveAuthor(Author theAuthor) {
		
		bookDao.saveNewAuthor(theAuthor);
		
	}
	
}
