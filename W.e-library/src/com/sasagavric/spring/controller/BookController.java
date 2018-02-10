package com.sasagavric.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sasagavric.entity.Author;
import com.sasagavric.entity.Book;
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
	 * Show 10 books, based on number of page
	 * @param page
	 * @param model
	 * @return String
	 */
	@GetMapping("/bookList")
	public String getBooks(@RequestParam(value = "page",defaultValue="0") int page, Model model) {

		// get all books
		List<Book> listofBooks = bookService.getListOfBooks(page);

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

		// create book object for data binding
		Book theBook = new Book();

		// get all authors
		List<Author> listOfAuthors = bookService.getListOfAuthors();

		model.addAttribute("book", theBook);
		model.addAttribute("listOfAuthors", listOfAuthors);

		return "bookForm";
	}

	
	/**
	 * Persist Book object to database
	 * @param theBook
	 * @param br
	 * @param page
	 * @param model
	 * @param redirectAttributes
	 * @return String (redirect to bookList)
	 */
	@PostMapping("/saveBook")
	public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult br,
			@RequestParam("page") int page, Model model, RedirectAttributes redirectAttributes) {

		redirectAttributes.addAttribute("page", page);

		if (br.hasErrors()) {
			// get all authors
			List<Author> listOfAuthors = bookService.getListOfAuthors();
			model.addAttribute("listOfAuthors", listOfAuthors);
			return "bookForm";
		} else {
			// save book to database
			bookService.saveBook(theBook);
			return "redirect:bookList";
		}

	}

	/**
	 * Update existing book
	 * @param theId
	 * @param page
	 * @param redirectAttributes
	 * @param model
	 * @return String
	 */
	@GetMapping("/updateBook")
	public String updateBook(@RequestParam("id") int theId, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes, Model model) {

		// get book
		Book theBook = bookService.getBook(theId);

		// get all authors
		List<Author> listOfAuthors = bookService.getListOfAuthors();
		model.addAttribute("listOfAuthors", listOfAuthors);
		model.addAttribute("book", theBook);
		redirectAttributes.addAttribute("page", page);

		return "bookForm";
	}


	/**
	 * View details of one book (id, title, date of publishing, language, etc.) via
	 * book id, and add book to Model.
	 * @param theId
	 * @param page
	 * @param redirectAttributes
	 * @param model
	 * @return String
	 */
	@GetMapping("/viewBook")
	public String viewBook(@RequestParam("id") int theId, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes, Model model) {

		// get book from database
		Book theBook = bookService.getBook(theId);

		// add book to model
		model.addAttribute("book", theBook);
		redirectAttributes.addAttribute("page", page);

		return "bookView";
	}


	/**
	 * Some books have description and this method will provide description for
	 * specific book
	 * @param theId
	 * @param model
	 * @param page
	 * @param redirectAttributes
	 * @return String
	 */
	@GetMapping("/bookOverview")
	public String bookOverview(@RequestParam("bookId") int theId, Model model, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes) {

		// get book id,title and description from database
		Book theBook = bookService.getBook(theId);

		String bookTitle = theBook.getTitle();
		String bookDescription = theBook.getDescription();

		// add title and desccription to model
		model.addAttribute("description", bookDescription);
		model.addAttribute("title", bookTitle);
		model.addAttribute("id", theId);
		redirectAttributes.addAttribute("page", page);

		return "bookOverview";
	}

	
	/**
	 * Search for one or more books in database via book title (full title or word-s in book)
	 * @param theName
	 * @param page
	 * @param redirectAttributes
	 * @param model
	 * @return String
	 */
	@PostMapping("/bookSearch")
	public String bookSearch(@RequestParam("name") String theName, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes, Model model) {

		// get requested books from data base
		List<Book> listOfBooks = bookService.searchForBook(theName);

		// add books to model
		model.addAttribute("books", listOfBooks);
		model.addAttribute("backButton", true);
		redirectAttributes.addAttribute("page", page);

		return "bookList";
	}

	
	/**
	 * Delete selected book from database
	 * @param theId
	 * @param page
	 * @param redirectAttributes
	 * @return String (redirect to bookList)
	 */
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int theId, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes) {

		Book theBook = bookService.getBook(theId);

		bookService.deleteBook(theBook);

		redirectAttributes.addAttribute("page", page);

		return "redirect:bookList";
	}

	
	/**
	 * If new book has no author, this method will provide form for adding new author
	 * @param model
	 * @param page
	 * @param redirectAttributes
	 * @return String
	 */
	@GetMapping("/authorForm")
	public String getAuthorForm(Model model, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {

		Author theAuthor = new Author();

		model.addAttribute("author", theAuthor);
		redirectAttributes.addAttribute("page", page);

		return "authorForm";
	}

	
	/**
	 * Persist new author in database
	 * @param theAuthor
	 * @param br
	 * @param page
	 * @param redirectAttributes
	 * @return String
	 */
	@PostMapping("/saveAuthor")
	public String saveAuthor(@Valid @ModelAttribute("author") Author theAuthor, BindingResult br,
			@RequestParam("page") int page, RedirectAttributes redirectAttributes) {

		redirectAttributes.addAttribute("page", page);

		if (br.hasErrors()) {
			return "authorForm";
		} else {
			bookService.saveAuthor(theAuthor);
			return "redirect:bookForm";
		}
	}
	
}
