package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "/member/"+ step;
	}
	
	@RequestMapping("/saveMemberForm")
	public String insertMemberForm(MemberVO vo) throws IOException {
		memberService.insertMemberForm(vo);
		return "/member/LoginForm";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String login(MemberVO vo, Model model, HttpSession session) {
		
		MemberVO result = memberService.login(vo);
		if(result != null) {
	
			model.addAttribute("mem",result);
			session.setAttribute("member", result);
			return "/member/loginSuccess";
		}else {
		
			return "/member/loginForm";
		}	
	}
	

	
	
}
