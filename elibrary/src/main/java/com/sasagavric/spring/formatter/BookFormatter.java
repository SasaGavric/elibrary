package com.sasagavric.spring.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import com.sasagavric.entity.Book;
import com.sasagavric.spring.service.book.BookService;

/**
 * @author Sasa Gavric
 *
 */
@Component
public class BookFormatter implements Formatter<Book> {
	
	private BookService bookService;
	
	@Autowired
	public BookFormatter(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String print(Book book, Locale arg1) {
		// TODO Auto-generated method stub
		return book.toString();
	}

	/* convert String id to Book object
	 * @see org.springframework.format.Parser#parse(java.lang.String, java.util.Locale)
	 */
	@Override
	public Book parse(String bookId, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		return bookService.getBook(Integer.parseInt(bookId));
	}

}
