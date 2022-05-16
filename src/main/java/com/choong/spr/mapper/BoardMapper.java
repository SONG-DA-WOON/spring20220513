package com.choong.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choong.spr.domain.BoardDto;

@Mapper
public interface BoardMapper {
	String selectCustomerNameById(int id);

	String selectEmployeeFirstNameById(int id);

	List<BoardDto> selectBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);

	boolean getBoard(BoardDto board);

	List<BoardDto> listBoard();
}