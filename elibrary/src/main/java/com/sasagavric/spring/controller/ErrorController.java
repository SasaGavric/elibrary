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
	 * return error landing page
	 * @return 
	 * @throws Exception 
	 */
	@GetMapping("/errors")
	public String handleAllErors() throws Exception {
		return "error";
	}
	
}
