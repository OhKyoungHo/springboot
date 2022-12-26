package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.persistence.BoardRepository;
@Service
//alt shift t 누르고 extract interface 누르면 해당되는 인터페이스 생성 가능
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		return (List<BoardVO>)boardRepo.findAll();
	}
	
	public void saveBoard(BoardVO vo) {
		boardRepo.save(vo);
	};

	public BoardVO getBoard(BoardVO vo) {
		//optional에서 값만 가져와야해서 get써줌
		return boardRepo.findById(vo.getSeq()).get();
	}
	
	public void deleteBoard(BoardVO vo) {
		boardRepo.deleteById(vo.getSeq());
	};
	
	public void updateBoard(BoardVO vo) {
		BoardVO result = boardRepo.findById(vo.getSeq()).get();
		result.setTitle(vo.getTitle());
		result.setContent(vo.getContent());
		boardRepo.save(result);
	}
}
