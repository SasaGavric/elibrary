package com.sasagavric.spring.dao.member;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sasagavric.entity.Member;


/**
 * @author Sasa Gavric
 *
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SessionFactory factory;

	/* Get all members from database
	 * @see com.sasagavric.spring.dao.member.MemberDAO#listOfMembers()
	 */
	@Override
	public List<Member> listOfMembers(int page) {
		
		//create session
		Session session = factory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Member> listOfMembers = session.createQuery("from Member").setFirstResult(page).setMaxResults(11).getResultList();
	
		return listOfMembers;
	}

	/* Update if object is already persisted in database or save if client add new member
	 * @see com.sasagavric.spring.dao.member.MemberDAO#saveMember(com.sasagavric.spring.entity.Member)
	 */
	@Override
	public void saveMember(Member theMember) {
		
		//create Session
		Session session = factory.getCurrentSession();
		
		System.out.println("theMember id:  " + theMember.getId());
		
		//save or update member
		session.saveOrUpdate(theMember);
			
	}

	/* get one member from database via member id
	 * @see com.sasagavric.spring.dao.member.MemberDAO#getCustomer(int)
	 */
	@Override
	public Member getMember(int theId) {
		//create Session
		Session session = factory.getCurrentSession();
		
		//get Member from data base via primary key
		Member theMember = session.get(Member.class, theId);
		
		return theMember;
		
	}

	@Override
	public void deleteMember(int theId) {
		//create Session
		Session session = factory.getCurrentSession();
		
		//create query for deleting member from data base
		@SuppressWarnings("unchecked")
		Query<Member> query = session.createQuery("delete from Member m where m.id=:memberId");
		
		//register parameters in query
		query.setParameter("memberId", theId);
		
		//execute query
		System.out.println("Execute");
		query.executeUpdate();
		
	}

	@Override
	public List<Member> searchForMember(String firstName, String lastName) {
		
		Session session = factory.getCurrentSession();
		
		//search for members via first and last name
		@SuppressWarnings("unchecked")
		Query<Member> memberQuery = session.createQuery("from Member m where m.firstName=:firstN AND m.lastName=:lastN");
		memberQuery.setParameter("firstN", firstName);
		memberQuery.setParameter("lastN", lastName);
		
		//get members
		List<Member> listOfSelectedMembers = memberQuery.getResultList();
		
		return listOfSelectedMembers;
	}

	@Override
	public List<Member> searchForMember(String firstOrLastName) {
		
		Session session = factory.getCurrentSession();
		
		//search for members via  first name or last name
		@SuppressWarnings("unchecked")
		Query<Member> memberQuery = session.createQuery("from Member m where m.firstName=:param OR m.lastName=:param");
		memberQuery.setParameter("param", firstOrLastName);
		
		//get members
		List<Member> listOfSelectedMembers = memberQuery.getResultList();
		
		return listOfSelectedMembers;
	}

}
