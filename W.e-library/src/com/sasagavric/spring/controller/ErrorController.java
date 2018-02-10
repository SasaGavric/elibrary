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
	 * @return String (cat error landing page)
	 * @throws Exception 
	 */
	@GetMapping("/errors")
	public String handleAllErors() throws Exception {
		return "error";
	}
	
}
