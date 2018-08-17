package com.sasagavric.spring.service.borrowReturn;


import java.util.List;
import com.sasagavric.entity.Book;
import com.sasagavric.entity.BorrowedBook;
import com.sasagavric.entity.Member;

/**
 * @author Sasa Gavric
 *
 */
public interface BorrowReturnService {
	
	public List<Member> getAllMembers();
	
	public Member getMember(int memberId);

	public List<Book> getAllAvailableBooks();

	public void borrowBook(BorrowedBook theBorrowedBook);

	public void returnBook(int borrowedBookId, int bookId);




}
