  package com.choong.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.PageInfoDto;
import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.BoardService;
import com.choong.spr.service.ReplyService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private ReplyService replyService;
	
//	@GetMapping("board/list")
//	public void listBoard(Model model) {
//		List<BoardDto> list = service.listBoard();
//		
//		model.addAttribute("boardList", list);
//		
//	}

	@GetMapping("board/list")
	public String pagination(@RequestParam(name = "page", defaultValue = "1") int page, 
							 @RequestParam(name = "type", defaultValue = "") String type,
							 @RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
							
		int rowPerPage = 10;
		List<BoardDto> list = service.listBoardPage(page, rowPerPage);
		List<BoardDto> list2 = service.listBoard(type, keyword);

		int totalRecords = service.countBoard();

		int end = (totalRecords - 1) / rowPerPage + 1;

		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("boardBoard", list2);
		model.addAttribute("boardList", list);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/board/list";

	}

	@GetMapping("board/{id}") // 조회
	public String getBoard(@PathVariable("id") int id, Model model) {
		System.out.println(id);

		BoardDto dto = service.getBoard(id);

		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);

		model.addAttribute("board", dto);
		model.addAttribute("replyList", replyList);

		return "/board/get";
	}

	@PostMapping("board/modify") // 추가
	public String modifyBoard(BoardDto board, RedirectAttributes rttr) {
		boolean success = service.updateBoard(board);

		if (success) {
			rttr.addFlashAttribute("message", "글이 수정되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "글이 수정되지 않았습니다.");
		}

		return "redirect:/board/" + board.getId();
	}

	@PostMapping("board/remove")
	public String removeBoard(int id, RedirectAttributes rttr) {
		boolean success = service.removeBoardById(id);

		if (success) {
			rttr.addFlashAttribute("message", "글이 삭제 되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "글이 삭제 되지않았습니다.");
		}

		return "redirect:/board/list";
	}

	@GetMapping("board/write")
	public void writeBoard() {

	}

	@PostMapping("board/write")
	public String writeBoardProcess(BoardDto board) {
		boolean success = service.addBoard(board);

		if (success) {

		} else {

		}

		return "redirect:/board/" + board.getId();
	}

}