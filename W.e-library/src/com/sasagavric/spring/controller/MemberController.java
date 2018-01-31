package com.sasagavric.spring.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sasagavric.spring.entity.Member;
import com.sasagavric.spring.service.member.MemberService;

/**
 * @author Sasa Gavric
 *
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	ApplicationContext applicationContext;

	/**
	 * Add all members from database in Model, and return memberList.jsp page,
	 * which will display members to client. 
	 * @param model
	 * @return String 
	 */
	@GetMapping("/homePage")
	public String homePage(Model model) {

		List<Member> listOfMembers = memberService.getListOfMembers();
		model.addAttribute("members", listOfMembers);
		
		return "memberList";
	}

	
	/**
	 * Return form for adding new member to database via data binding
	 * @param model
	 * @return String 
	 */
	@GetMapping("/memberForm")
	public String customerForm(Model model) {

		Member theMember = new Member();
		model.addAttribute("member", theMember);

		return "memberForm";
	}

	/**
	 * When client fill out form, this method will validate form data.
	 * If form data is valid new member will be saved to database, if form data is not 
	 * valid error message will appear on form.
	 * @param theMember
	 * @param bindingResult
	 * @return String 
	 */
	@PostMapping("/saveMember")
	public String saveCustomer(@Valid@ModelAttribute("member") Member theMember, BindingResult bindingResult) {
		
		//perform form validation
		if (bindingResult.hasErrors()) {
			return "memberForm";
		} else {
			memberService.saveMember(theMember);
			return "redirect:homePage";
		}
	}
	
	/**
	 * Updating existed member via member id
	 * @param theId
	 * @param model
	 * @param request
	 * @return String 
	 */
	@GetMapping(value= {"/updateMember", "/viewMember"})
	public String updateMember(@RequestParam("id") int theId, Model model, HttpServletRequest request) {
		
		//get member from data base via member primary key(id)
		Member theMember = memberService.getMember(theId);
		
		//add member to model for data binding
		model.addAttribute("member", theMember);
		
		//get Servlet path
		String requestPath = request.getServletPath();
	
		if(requestPath.endsWith("/updateMember")) {
			return "memberForm";
		}else {
			return "viewMember";
		}
	}
	
	/**
	 * Delete member from database via member id
	 * @param theId
	 * @return String 
	 */
	@GetMapping("/deleteMember")
	public String deleteMember(@RequestParam("id") int theId) {
		
		//delete member from data base via id
		memberService.deleteMember(theId);
		
		return "redirect:homePage";
	}
	
	//search for member by name
	/**
	 * Search for book in database via book id
	 * @param bookTitle
	 * @param model
	 * @return String 
	 */
	@PostMapping("/memberSearch")
	public String searchForMember(@RequestParam("memberName") String bookTitle, Model model) {
		
		//get members
		List<Member> listOfSelectedMembers = memberService.searchMember(bookTitle);
		
		//add members to model
		model.addAttribute("members", listOfSelectedMembers);
		model.addAttribute("backButton", true);
		
		return "memberList";
	}
	
	
	

}
