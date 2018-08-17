package com.sasagavric.spring.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sasagavric.entity.Book;
import com.sasagavric.entity.BorrowedBook;
import com.sasagavric.entity.Member;
import com.sasagavric.spring.service.borrowReturn.BorrowReturnService;

/**
 * @author Sasa Gavric
 *
 */
@Controller
@RequestMapping("/borrowReturn")
public class BorrowReturnController {

	
	private BorrowReturnService borrowReturnService;
	
	@Autowired
	public BorrowReturnController(BorrowReturnService borrowReturnService) {
		this.borrowReturnService = borrowReturnService;
	}

	/**
	 * return page for choosing member
	 * 
	 * @param page
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
	@GetMapping("/chooseMemberId")
	public String choseMemberId(@RequestParam("page") int page, RedirectAttributes redirectAttributes, Model model) {

		List<Member> listOfAllMembers = borrowReturnService.getAllMembers();

		model.addAttribute("members", listOfAllMembers);

		redirectAttributes.addAttribute("page", page);

		return "borrowReturnMemberId";
	}

	/**
	 * borrow or return book
	 * 
	 * @param member
	 * @param page
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
	@GetMapping("/borrowReturnBook")
	public String borrowOrReturnBook(@RequestParam("memberId") @Valid Member member, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes, Model model) {

		BorrowedBook theBorrowedBook = new BorrowedBook();

		List<Book> listOfAvailableBooks = borrowReturnService.getAllAvailableBooks();

		model.addAttribute("borrowedBook", theBorrowedBook);
		model.addAttribute("availableBooks", listOfAvailableBooks);
		model.addAttribute("member", member);

		redirectAttributes.addAttribute("page", page);
		return "borrowReturnBook";
	}

	/**
	 * borrow one book
	 * 
	 * @param theBorrowedBook
	 * @param member
	 * @param page
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/borrowBook")
	public String borrowBook(@ModelAttribute("borrowedBook") @Valid BorrowedBook theBorrowedBook,
			@RequestParam("memberId") @Valid Member member, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes) {

		theBorrowedBook.setDateOfBorrowing(new Date());
		theBorrowedBook.setMember(member);

		borrowReturnService.borrowBook(theBorrowedBook);

		redirectAttributes.addAttribute("page", page);
		redirectAttributes.addAttribute("memberId", member.getId());
		return "redirect:borrowReturnBook";
	}

	/**
	 * return one book via BorrowBook id
	 * 
	 * @param borrowedBookId
	 * @param member
	 * @param page
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/returnBook")
	public String returnBook(@RequestParam("id") int borrowedBookId, @RequestParam("memberId") @Valid Member member,
			@RequestParam("bookId") int bookId, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {

		borrowReturnService.returnBook(borrowedBookId, bookId);

		redirectAttributes.addAttribute("page", page);
		redirectAttributes.addAttribute("memberId", member.getId());
		return "redirect:borrowReturnBook";
	}

}
