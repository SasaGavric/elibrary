package com.sasagavric.spring.service.borrowReturn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sasagavric.entity.Book;
import com.sasagavric.entity.BorrowedBook;
import com.sasagavric.entity.Member;
import com.sasagavric.spring.dao.borrowedBook.BorrowedBookDAO;
import com.sasagavric.spring.dao.member.MemberDAO;

/**
 * @author Sasa Gavric
 *
 */
@Service
public class BorrowReturnServiceImpl implements BorrowReturnService {

	private MemberDAO memberDao;
	private BorrowedBookDAO borrowedBookDAO;
	
	@Autowired
	public BorrowReturnServiceImpl(MemberDAO memberDao, BorrowedBookDAO borrowedBookDAO) {
		this.memberDao = memberDao;
		this.borrowedBookDAO = borrowedBookDAO;
	}

	@Override
	@Transactional
	public Member getMember(int memberId) {
		return memberDao.getMember(memberId);
	}

	@Override
	@Transactional
	public List<Member> getAllMembers() {
		return memberDao.listOfAllMembers();
	}

	@Override
	@Transactional
	public List<Book> getAllAvailableBooks() {
		return memberDao.getAllAvailableBooks();
	}

	@Override
	@Transactional
	public void borrowBook(BorrowedBook theBorrowedBook) {
		borrowedBookDAO.borrowOneBook(theBorrowedBook);
	}

	@Override
	@Transactional
	public void returnBook(int borrowedBookId, int bookId) {
		borrowedBookDAO.returnBorrowedBook(borrowedBookId, bookId);
		
	}

}
