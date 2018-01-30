package com.sasagavric.spring.dao.book;

import java.util.List;

import com.sasagavric.spring.entity.Author;
import com.sasagavric.spring.entity.Book;

/**
 * @author Sasa Gavric
 *
 */
public interface BookDAO {
	
	public List<Book> getListOfBooks();

	public Book getBook(int theId);

	public List<Book> searchFoBook(String bookTitle);

	public void deleteBook(Book theBook);

	public List<Author> getListOfAuthors();

	public void saveBookToDataBase(Book theBook);

	public Author getAuthor(int authorId);

}
