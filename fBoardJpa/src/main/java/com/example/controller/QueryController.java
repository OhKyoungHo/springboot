package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.QueryAnnoRepository;
@Controller
public class QueryController {
	
	@Autowired
	private QueryAnnoRepository repo;
	
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		//m.addAttribute("boardList", repo.queryAnnotation("s"));
		//m.addAttribute("boardList", repo.queryAnnotation2("s"));
		m.addAttribute("boardList", repo.queryAnnotation2("s"));
		return "/board/getBoardList";
	}
	
	 @RequestMapping("/queryanno3")
	   public String queryanno3(Model m) {
	      System.out.println("HERE");
	      m.addAttribute("boardList", repo.queryAnnotation3("2"));
	      return "board/getBoardList2";
	   }
	
}
