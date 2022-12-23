package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;
import com.example.service.BoardService;
import com.example.util.MD5Generator;

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
	//	@RequestMapping("/saveBoard")
	//	public String insertBoard(BoardVO bvo, FileVO fvo) throws IOException {
	//		boardService.insertBoard(bvo,fvo);
	//		return "redirect:/board/getBoardList";
	//	}
	// 글등록 ************
	@RequestMapping(value = "/saveBoard")
	public String insertBoard(@RequestParam("file") MultipartFile files,BoardVO vo) throws IOException {
		try {
			System.out.println("saveBoard 요청");
			String origFilename = files.getOriginalFilename();
			System.out.println("origFilename : " + origFilename);

			// 파일첨부를한경우에만
			if( origFilename != null&& !origFilename.equals(""))
			{   	

				String filename = new MD5Generator(origFilename).toString();
				/* 실행되는위치의 'files' 폴더에파일이저장됩니다. */
				String savePath = System.getProperty("user.dir") + "\\files";
				/* 파일이저장되는폴더가없으면폴더를생성합니다. */
				if (!new File(savePath).exists()) {
					try{
						new File(savePath).mkdir();
					}
					catch(Exception e){
						e.getStackTrace();
					}
				}
				String filepath = savePath + "\\" + filename;
				System.out.println("filepath : "+filepath);

				files.transferTo(new File(filepath));

				FileVO fileVO = new FileVO();
				fileVO.setOrigFilename(origFilename);
				fileVO.setFilename(filename);
				fileVO.setFilepath(filepath);

				boardService.insertBoard(vo, fileVO);
				System.out.println("파일첨부인경우");
			}else {
				boardService.insertBoard(vo, null);
				System.out.println("파일첨부가아닌경우");
			}
		} catch(Exception e) {
			System.out.println("파일업로드실패:" + e.getMessage());
			e.printStackTrace();
		}
		return"redirect:/board/getBoardList";
	}



	// 글 수정
	@RequestMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/board/getBoard?seq="+vo.getSeq();
	}

	// 글 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:/board/getBoardList";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard")
	public void getBoard(BoardVO vo, Model model) {
		HashMap result = boardService.getBoard(vo);
		model.addAttribute("board",result ); // Model 정보 저장			
	}

}
