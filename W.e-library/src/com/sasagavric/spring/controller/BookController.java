package com.sasagavric.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sasagavric.spring.entity.Author;
import com.sasagavric.spring.entity.Book;
import com.sasagavric.spring.service.book.BookService;

/**
 * @author Sasa Gavric
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Show all available books from database, and add that books to model
	 * @param model 
	 * @return String 
	 */
	@GetMapping("/bookList")
	public String getBooks(Model model) {

		//get all books
		List<Book> listofBooks = bookService.getListOfBooks();
		
		
		model.addAttribute("books", listofBooks);
		
		return "bookList";
	}
	
	/**
	 * Return form for adding new book to database via data binding
	 * @param model
	 * @return String
	 */
	@GetMapping("/bookForm")
	public String bookForm(Model model) {
		
		//create book object for data binding
		Book theBook = new Book();
		
		//get all authors
		List<Author> listOfAuthors= bookService.getListOfAuthors();
		
		model.addAttribute("book", theBook);
		model.addAttribute("listOfAuthors", listOfAuthors);
		
		return "bookForm";
	}
	

	/**
	 * Persist Book object to database
	 * @return
	 */
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		//save book to database
		bookService.saveBook(theBook);
		
		return "redirect:bookList";
	}
	
	
	/**
	 * View details of one book (id, title, date of publishing, language, etc.) via book id, 
	 * and add book to Model.
	 * @param theId
	 * @param model
	 * @return String
	 */
	@GetMapping("/viewBook")
	public String viewBook(@RequestParam("id") int theId, Model model) {
		
		//get book from database
		Book theBook = bookService.getBook(theId);
		
		theBook.getListOfAuthors().forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
		
		//add book to model
		model.addAttribute("book", theBook);
		
		return "bookView";
	}
	
	/**
	 * Some books have description and this method will provide description
	 * for specific book
	 * @param theId
	 * @param model
	 * @return String
	 */
	@GetMapping("/bookOverview")
	public String bookOverview(@RequestParam("bookId") int theId, Model model) {
		
		//get book id,title and  description from database
		Book theBook = bookService.getBook(theId);
		
		String bookTitle = theBook.getTitle();
		String bookDescription = theBook.getDescription();
		
		//add title and desccription to model
		model.addAttribute("description", bookDescription);
		model.addAttribute("title", bookTitle);
		model.addAttribute("id", theId);
		
		return "bookOverview";
	}
	
	/**
	 * Search for one or more books in database via book title
	 * @param theName
	 * @param model
	 * @return
	 */
	@PostMapping("/bookSearch")
	public String bookSearch(@RequestParam("name")String theName, Model model) {
		
		//get requested books from data base
		List<Book> listOfBooks = bookService.searchForBook(theName);
		
		//add books to model
		model.addAttribute("books", listOfBooks);
		model.addAttribute("backButton", true);
		
		
		return "bookList";
	}
	
	/**
	 * Delete one book from database
	 * @param theId
	 * @return
	 */
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int theId) {
		
		Book theBook = bookService.getBook(theId);
		
		bookService.deleteBook(theBook);
		
		return "redirect:bookList";
	}
	
	
	/**
	 * Return form for adding new author to database via data binding
	 * @param model
	 * @return
	 */
	@GetMapping("/authorForm")
	public String getAuthorForm(Model model) {
		
		Author theAuthor = new Author();
		
		model.addAttribute("author", theAuthor);
		
		return "authorForm";
	}
	
	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author theAuthor) {
		
		System.out.println(theAuthor.getFirstName() +" "+ theAuthor.getLastName() + "\n" + theAuthor.getDescription());
		
		bookService.saveAuthor(theAuthor);
		
		return "redirect:bookForm";
	}

}
