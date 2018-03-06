package com.sasagavric.spring.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author Sasa Gavric
 *
 */
@ControllerAdvice
public class AdviceController {

	/** init binder which will convert String data to valid format (trim String)
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		// Create custom editor which will trim all white spaces from String
		// or it will return null if there is only white spaces
		StringTrimmerEditor ste = new StringTrimmerEditor(true);

		// Register custom editor
		dataBinder.registerCustomEditor(String.class, ste);

	}

}
