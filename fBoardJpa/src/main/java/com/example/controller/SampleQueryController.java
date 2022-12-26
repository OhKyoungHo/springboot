package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.domain.BoardVO;
import com.example.persistence.SampleQueryRepositoty;

@Controller
public class SampleQueryController {

	@Autowired
	private SampleQueryRepositoty repo;

	@RequestMapping("/sampleQuery")
	   public String sampleQuery(Model m) {
	      Pageable paging = PageRequest.of(0, 11);
	      List<BoardVO> result = repo.findAll(paging);
//	      repo.findBoardVOByTitleContainingOrderByTitleDesc("경")
	      m.addAttribute("boardList", result);
	      return "board/getBoardList";
	   }


}
