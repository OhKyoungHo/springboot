package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "board/"+ step;
	}
	
	
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO();
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("[Controller:getBoardList 요청] 결과갯수 : " + list.size());
		
		m.addAttribute("boardList", list);
	}
	
	// 글 등록
	@RequestMapping("/saveBoard")
	public String saveBoard(BoardVO vo){
		boardService.saveBoard(vo);
		return "redirect:getBoardList";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard")
	public void getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장			
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:/board/getBoardList";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/board/getBoard?seq="+vo.getSeq();
	}
	
}
