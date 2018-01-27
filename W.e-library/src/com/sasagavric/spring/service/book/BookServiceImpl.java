package com.sasagavric.spring.service.book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasagavric.spring.dao.book.BookDAO;
import com.sasagavric.spring.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;

	@Override
	@Transactional
	public List<Book> getListOfBooks() {
		//get all books
		return bookDao.getListOfBooks();
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
	
}
