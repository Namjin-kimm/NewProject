package com.iu.home.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@GetMapping("login")
	public void getLogin()throws Exception {
		
	}
	
	@GetMapping("join")
	public String setJoin (@ModelAttribute MemberVO memberVO)throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		return mv;
	}

}
