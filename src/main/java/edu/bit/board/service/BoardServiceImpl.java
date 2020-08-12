package edu.bit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service("service")
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Inject 
	private BoardMapper mapper; //mapper는 무조건 interface 다
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList......");
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bno) {
		log.info("get......");
//		mapper.upHit(bno);
//		log.info("upHit......");
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		log.info("remove......");
		
		return mapper.delete(bno);
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		log.info("write...");
		mapper.insertBoard(boardVO);
	}

//	@Override
//	public void writeBoard(BoardVO boardVO) {
//		mapper.updateShape(boardVO);
//		mapper.insertReply(boardVO);
//	}
	@Override
	public void writeBoard(BoardVO boardVO) {
		mapper.insertBoard(boardVO);
		
	}

	@Transactional
	@Override
	public void writeReply(BoardVO boardVO) {
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
	}

	@Override
	public void modify(BoardVO boardVO) {
		mapper.modify(boardVO);
	}

	
	
	
}
