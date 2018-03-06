package com.sasagavric.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Sasa Gavric
 *
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * set DispatcherServlet config class
	 *  (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}

	/* 
	 * set up URL mapping for Spring MVC DispatcherServlet
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	

}
