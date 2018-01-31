package com.sasagavric.spring.service.member;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasagavric.spring.dao.member.MemberDAO;
import com.sasagavric.spring.entity.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	@Transactional
	public List<Member> getListOfMembers() {
		return memberDao.listOfMembers();
	}

	@Override
	@Transactional
	public void saveMember(Member theMember) {
		memberDao.saveMember(theMember);
		
	}

	@Override
	@Transactional
	public Member getMember(int theId) {
		return memberDao.getMember(theId);
	}

	@Override
	@Transactional
	public void deleteMember(int theId) {
		
		memberDao.deleteMember(theId);
		
	}

	@Override
	@Transactional
	public List<Member> searchMember(String memberName) {
		
		//create list
		List<Member> listOfSelectedMembers;
		
		//get first and last name 
		
		String[] firstAndLastName = memberName.split(" ");
			
		switch(firstAndLastName.length) {
		//first or last name
		case 1: listOfSelectedMembers = memberDao.searchForMember(firstAndLastName[0].trim());
			break;
		//first and last name
		case 2: listOfSelectedMembers = memberDao.searchForMember(firstAndLastName[0].trim(), firstAndLastName[1].trim());
			break;
		//search is wrong
		default:
			listOfSelectedMembers = null;	
		}
		
		return listOfSelectedMembers;
	}
	
	

}
