package com.sasagavric.spring.service.member;

import java.util.List;

import com.sasagavric.entity.Member;

/**
 * @author Sasa Gavric
 *
 */
public interface MemberService {

	public List<Member> getListOfMembers(int page);

	public void saveMember(Member theMember);

	public Member getMember(int theId);

	public void deleteMember(int theId);
	
	public List<Member> searchMember(String memberName);

}
