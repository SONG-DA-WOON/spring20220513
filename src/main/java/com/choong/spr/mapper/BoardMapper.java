package com.choong.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.choong.spr.domain.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);

	boolean getBoard(BoardDto board);

	List<BoardDto> listBoard();

	List<BoardDto> listBoardPage(@Param("from")int page, @Param("row")int rowPerPage);

	int countBoard();

	List<BoardDto> selectBoardAll(@Param("type")String type, @Param("keyword")String keyword);

	BoardDto selectBoardById(int id);

}