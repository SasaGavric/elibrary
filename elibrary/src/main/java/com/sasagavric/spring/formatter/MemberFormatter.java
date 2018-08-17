package com.sasagavric.spring.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import com.sasagavric.entity.Member;
import com.sasagavric.spring.service.member.MemberService;


/**
 * @author Sasa Gavric
 *
 */
@Component
public class MemberFormatter implements Formatter<Member> {

	@Autowired
	private MemberService memberService;
	
	@Override
	public String print(Member member, Locale arg1) {
		// TODO Auto-generated method stub
		return member.toString();
	}

	/* convert String id to Member object
	 * @see org.springframework.format.Parser#parse(java.lang.String, java.util.Locale)
	 */
	@Override
	public Member parse(String memberId, Locale arg1) throws ParseException {
			
		return memberService.getMember(Integer.parseInt(memberId));
	}

}
