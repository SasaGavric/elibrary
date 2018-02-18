package com.sasagavric.spring.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sasagavric.entity.Member;
import com.sasagavric.spring.dao.member.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	@Transactional
	public List<Member> getListOfMembers(int page) {
		return memberDao.listOfMembers(page);
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
