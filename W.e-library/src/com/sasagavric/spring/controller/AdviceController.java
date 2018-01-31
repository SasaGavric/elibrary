package com.sasagavric.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.sasagavric.spring.entity.Author;
import com.sasagavric.spring.service.book.BookService;

/**
 * @author Sasa Gavric
 *
 */
@ControllerAdvice
public class AdviceController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Handle all exception in app
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public String handleExceptions() {
		
		return "homePage";
	}
	
	
	/**
	 * init binder which will convert String data to valid format (trim String)
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
				
		//Create custom editor which will trim all white spaces from String 
		//or it will return null if there is only white spaces
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
				
		//Register custom editor
		dataBinder.registerCustomEditor(String.class, ste);
				
		}
	
	/**
	 * Convert author id to Author object
	 * @param binder
	 */
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
		
		System.out.println("----BINDER----");
		
     binder.registerCustomEditor(List.class, "listOfAuthors", new CustomCollectionEditor(List.class) {
    	 

            protected Object convertElement(Object element) {
                if (element != null) {
                    int authorId = Integer.parseInt(element.toString());
                    Author theAuthor = bookService.getById(authorId);
                    return theAuthor;

                }
                return null;
            }

        });

    }

}
