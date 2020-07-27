package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {

	List<BoardVO> getList(); //제네릭 타입만 적어주면 알아서 리스트 생성?
	BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bid = #{bno}")
	void delete(int bno);
	
	void insertBoard(BoardVO boardVO);
	
	void updateShape(@Param("BoardVO")BoardVO boardVO);
	void insertReply(BoardVO boardVO);
	void modify(@Param("boardVO")BoardVO boardVO);
}
