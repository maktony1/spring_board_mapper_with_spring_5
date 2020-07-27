package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList();
	BoardVO get(int bno);
	void remove(int bno);
	void insertBoard(BoardVO boardVO);
	void writeBoard(BoardVO boardVO);
	void writeReply(BoardVO boardVO);
	void modify(BoardVO boardVO);

	
}
