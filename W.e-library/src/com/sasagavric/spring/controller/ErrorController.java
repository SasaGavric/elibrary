package com.sasagavric.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sasa
 *
 */
@Controller
public class ErrorController {

	/**
	 * 
	 * @return String (cat error landing page)
	 */
	@GetMapping("/errors")
	public String handleAllErors() {
		System.out.println("ERORS");
		return "error";
	}
	
}
