package com.sasagavric.spring.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Sasa Gavric
 *
 */
@Aspect
@Component
public class EmailAspect {
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * If HibernateException occur in web app, send mail with description. 
	 * @param theJoinPoint
	 * @param exc
	 */
	@AfterThrowing(pointcut = "execution( * com.sasagavric.spring.dao.*.*.*(..) )", throwing="exc")
	public void adviceForEverything(JoinPoint theJoinPoint, HibernateException exc) {
		System.out.println("START SENDING");
		//send mail 
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo("springmvcsendexceptionmail@gmail.com");
		email.setSubject("Database problem " + new Date());
		email.setText(exc.getLocalizedMessage());
		
		mailSender.send(email);
		
		System.out.println("MAIL SENDED");
		
	}

}
