package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.FileDAO;
import com.example.domain.BoardVO;
import com.example.domain.FileVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 갯수:" + list.size());
		return list;
	}
	@Transactional
	public void insertBoard(BoardVO bvo, FileVO fvo) {
		
		//파일이 있는 경우
		if(fvo != null) {
			//파일 넣기
			fileDAO.insertFile(fvo);
			//파일 id 찾아서 fileVO에 있는 해당 파일 변수에 값 넣어주기
			bvo.setFileId(fileDAO.selectId());
		}
		boardDAO.insertBoard(bvo);
		System.out.println("게시글 입력완료");
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		System.out.println("게시글 수정완료");
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		System.out.println("게시글 삭제완료");
	}

	public HashMap getBoard(BoardVO vo) {
		System.out.println("게시글 조회완료");
		return boardDAO.getBoard(vo);
	}


}
