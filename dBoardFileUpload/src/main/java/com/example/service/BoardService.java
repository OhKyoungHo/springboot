package com.example.service;

import java.util.HashMap;
import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;

public interface BoardService {
	
	public List<BoardVO> getBoardList(BoardVO vo);
	
	public void insertBoard(BoardVO bvo, FileVO fvo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	public HashMap getBoard(BoardVO vo);

	

}
