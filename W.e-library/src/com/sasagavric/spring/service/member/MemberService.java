package com.sasagavric.spring.service.member;

import java.util.List;

import com.sasagavric.spring.entity.Member;

public interface MemberService {

	public List<Member> getListOfMembers();

	public void saveCustomer(Member theMember);

	public Member getMember(int theId);

	public void deleteMember(int theId);
	
	public List<Member> searchMember(String memberName);

}
