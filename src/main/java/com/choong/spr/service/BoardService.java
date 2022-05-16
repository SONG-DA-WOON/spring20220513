package com.choong.spr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.mapper.BoardMapper;
import com.choong.spr.mapper.ReplyMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	@Autowired
	private ReplyMapper replyMapper;

	public String getCustomerNameById(int id) {
		return mapper.selectCustomerNameById(id);
	}

	public String getEmployeeFirstNameById(int id) {
		return mapper.selectEmployeeFirstNameById(id);
	}

	public List<BoardDto> listBoard() {
		return mapper.selectBoard();
	}

	public boolean getBoard(BoardDto board) {
		return mapper.getBoard(board);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);

		return cnt == 1;
	}

	public boolean removeBoardById(int id) {

		replyMapper.deleteReplyByBoard(id);

		int cnt = mapper.deleteBoard(id);

		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());

		int cnt = mapper.insertBoard(board);

		return cnt == 1;
	}

	public BoardDto getBoard(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}