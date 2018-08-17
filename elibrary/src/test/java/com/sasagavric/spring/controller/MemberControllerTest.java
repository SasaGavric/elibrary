package com.sasagavric.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import com.sasagavric.spring.service.member.MemberService;

public class MemberControllerTest {
	
	MemberController memberController;
	
	@Mock
	MemberService memberService;
	
	@Mock
	Model model;

	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		
		memberController = new MemberController(memberService);
		
		mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
		
	}
	

	
	
	@Test
	public void testHomePage() throws Exception {
		MockMvc mockMvc  = MockMvcBuilders.standaloneSetup(memberController).build();
		
		mockMvc.perform(get("/member/homePage"))
		.andExpect(status().isOk())
		.andExpect(view().name("memberList"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("members"));	
		
	}

	@Test
	public void testCustomerForm() {
		
	}

	@Test
	public void testSaveCustomer() {
	
	}

	@Test
	public void testUpdateMember() {
		
	}

	@Test
	public void testDeleteMember() {
		
	}

	@Test
	public void testSearchForMember() {
		
	}

}
