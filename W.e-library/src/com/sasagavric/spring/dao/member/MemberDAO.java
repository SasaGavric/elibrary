package com.sasagavric.spring.dao.member;

import java.util.List;

import com.sasagavric.spring.entity.Member;


public interface MemberDAO {

	public List<Member> listOfMembers();

	public void saveMember(Member theMember);

	public Member getCustomer(int theId);

	public void deleteMember(int theId);

	public List<Member> searchForMember(String firstName, String lastName);

	public List<Member> searchForMember(String firstOrLastName);
	
}