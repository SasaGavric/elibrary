package com.sasagavric.spring.service.book;

import java.util.List;

import com.sasagavric.spring.entity.Author;
import com.sasagavric.spring.entity.Book;

public interface BookService {
	
	public List<Book> getListOfBooks();

	public Book getBook(int theId);

	public List<Book> searchForBook(String bookTitle);

	public void deleteBook(Book theBook);

	public List<Author> getListOfAuthors();
	

}
