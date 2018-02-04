package com.sasagavric.spring.service.book;

import java.util.List;

import com.sasagavric.spring.entity.Author;
import com.sasagavric.spring.entity.Book;

/**
 * @author Sasa Gavric
 *
 */
public interface BookService {
	
	public List<Book> getListOfBooks(int page);

	public Book getBook(int theId);

	public List<Book> searchForBook(String bookTitle);

	public void deleteBook(Book theBook);

	public List<Author> getListOfAuthors();

	public void saveBook(Book theBook);

	public Author getById(int authorId);

	public void saveAuthor(Author theAuthor);
	

}
