package com.sasagavric.spring.dao.borrowedBook;

import com.sasagavric.entity.BorrowedBook;

/**
 * @author Sasa Gavric
 *
 */
public interface BorrowedBookDAO {

	void borrowOneBook(BorrowedBook theBorrowedBook);

	void returnBorrowedBook(int borrowedBookId, int bookId);

}
