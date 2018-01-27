package com.sasagavric.spring.dao.book;

import java.util.List;

import com.sasagavric.spring.entity.Book;

public interface BookDAO {
	
	public List<Book> getListOfBooks();

	public Book getBook(int theId);

	public List<Book> searchFoBook(String bookTitle);

	public void deleteBook(Book theBook);

}
