package com.sasagavric.spring.dao.member;

import java.util.List;
import com.sasagavric.entity.Book;
import com.sasagavric.entity.Member;


/**
 * @author Sasa Gavric
 *
 */
public interface MemberDAO {

	public List<Member> listOfMembers(int page);
	
	public List<Member> listOfAllMembers();

	public void saveMember(Member theMember);

	public Member getMember(int theId);

	public void deleteMember(int theId);

	public List<Member> searchForMember(String firstName, String lastName);

	public List<Member> searchForMember(String firstOrLastName);

	public List<Book> getAllAvailableBooks();
	
}
