package com.kh.myEditor.board.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.myEditor.board.model.vo.Board;

@Mapper
public interface BoardMapper {
	int insertBoard(Board b);
}
