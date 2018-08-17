package com.sasagavric.spring.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sasagavric.entity.Member;
import com.sasagavric.spring.service.member.MemberService;

/**
 * @author Sasa Gavric
 *
 */
@Controller
@RequestMapping("/member")
public class MemberController {


	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}


	/**
	 * add all members from database in Model, and return memberList.jsp page,
	 * which will display members to client. 
	 * @param model
	 * @return  
	 */
	@GetMapping("/homePage")
	public String homePage(Model model, @RequestParam(name="page", defaultValue="0") int page) {

		List<Member> listOfMembers = memberService.getListOfMembers(page);
		model.addAttribute("members", listOfMembers);
		
		return "memberList";
	}

	
	/**
	 * return form for adding new member to database via data binding
	 * @param model
	 * @return  
	 */
	@GetMapping("/memberForm")
	public String customerForm(Model model, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {

		Member theMember = new Member();
		
		model.addAttribute("member", theMember);
		redirectAttributes.addAttribute("page", page);

		return "memberForm";
	}

	/**
	 * when client fill out form, this method will validate form data.
	 * If form data is valid new member will be saved to database, if form data is not 
	 * valid error message will appear on form.
	 * @param theMember
	 * @param bindingResult
	 * @return  
	 */
	@PostMapping("/saveMember")
	public String saveCustomer(@Valid@ModelAttribute("member") Member theMember, BindingResult bindingResult, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addAttribute("page", page);
		
		//perform form validation
		if (bindingResult.hasErrors()) {
			return "memberForm";
		} else {
			memberService.saveMember(theMember);
			return "redirect:homePage";
		}
	}
	
	/**
	 * updating existed member via member id
	 * @param theId
	 * @param model
	 * @param request
	 * @return  
	 */
	@GetMapping(value= {"/updateMember", "/viewMember"})
	public String updateMember(@RequestParam("id") int theId, Model model, HttpServletRequest request, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {
		
		//get member from data base via member primary key(id)
		Member theMember = memberService.getMember(theId);
		
		//add member to model for data binding
		model.addAttribute("member", theMember);
		redirectAttributes.addAttribute("page", page);
		
		//get Servlet path
		String requestPath = request.getServletPath();
		
	
		if(requestPath.endsWith("/updateMember")) {
			return "memberForm";
		}else {
			return "viewMember";
		}
	}
	
	/**
	 * delete member from database via member id
	 * @param theId
	 * @return  
	 */
	@GetMapping("/deleteMember")
	public String deleteMember(@RequestParam("id") int theId, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {
		
		//delete member from data base via id
		memberService.deleteMember(theId);
		
		redirectAttributes.addAttribute("page", page);
		
		return "redirect:homePage";
	}
	
	/**
	 * search for book in database via book id
	 * @param bookTitle
	 * @param model
	 * @return  
	 */
	@PostMapping("/memberSearch")
	public String searchForMember(@RequestParam("memberName") String bookTitle, Model model, @RequestParam("page") int page, RedirectAttributes redirectAttributes) {
		
		//get members
		List<Member> listOfSelectedMembers = memberService.searchMember(bookTitle);
		
		//add members to model
		model.addAttribute("members", listOfSelectedMembers);
		model.addAttribute("backButton", true);
		
		redirectAttributes.addAttribute("page", page);

		
		return "memberList";
	}

}
