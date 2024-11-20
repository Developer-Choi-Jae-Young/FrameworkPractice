package com.kh.myEditor.board.service;

import org.springframework.stereotype.Service;

import com.kh.myEditor.board.model.mapper.BoardMapper;
import com.kh.myEditor.board.model.vo.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;
	
	public int insertBoard(Board b) {
		return boardMapper.insertBoard(b);
	}
}
