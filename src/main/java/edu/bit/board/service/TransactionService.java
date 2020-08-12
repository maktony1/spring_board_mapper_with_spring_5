package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionService {

	private BoardMapper boardMapper;
	
	public void transionTest1() {
		
		log.info("transionTest1()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션1");
		boardVO.setbName("트랜잭션1");
		boardVO.setbTitle("트랜잭션1");

		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2");
		boardVO.setbName("트랜잭션2");
		boardVO.setbTitle("트랜잭션2");
		
		boardMapper.insertBoard(boardVO);
		
	}
	public void transionTest2() {
		
		log.info("transionTest2()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션2-1");
		boardVO.setbName("트랜잭션2-1");
		boardVO.setbTitle("트랜잭션2-1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션2-2");
		boardVO.setbName("트랜잭션2-2");
		boardVO.setbTitle("트랜잭션2-2");
		
		boardVO=null;
		
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transionTest3() {
		
		log.info("transionTest3()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션3-1");
		boardVO.setbName("트랜잭션3-1");
		boardVO.setbTitle("트랜잭션3-1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("트랜잭션3-2");
		boardVO.setbName("트랜잭션3-2");
		boardVO.setbTitle("트랜잭션3-2");
		
		//에러를 내기 위해서 //트랜잭션 테스트
		boardVO=null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	@Transactional
	public void transionTest4() {
		
		log.info("transionTest4()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션4-1");
		boardVO.setbName("트랜잭션4-1");
		boardVO.setbTitle("트랜잭션4-1");
		
		boardMapper.insertBoard(boardVO);
		
		//이놈은 강제적으로 에러 내는 애임 
		//런타임 에러 던져라 
		//트랜잭션은 내부에서 에러가 났을 때 롤백을 시킴 그럼 여기도 에러가 나니깐 롤백이 되야할듯? 
		throw new RuntimeException("RuntimeException for rollback");

		//SQLException은 오류가 안나나? 실행이 되는거같음 
		//throw new SQLException("RuntimeException for rollback");
	}
	@Transactional
	public void transionTest5() throws IOException {
		
		log.info("transionTest5()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션5-1");
		boardVO.setbName("트랜잭션5-1");
		boardVO.setbTitle("트랜잭션5-1");
		
		boardMapper.insertBoard(boardVO);
		
		//IOException도 실행이됨 트랜잭션 취소 안됨 이유는 뭘까?! 
		throw new IOException("IOException for rollback");
	}
	@Transactional(rollbackFor = Exception.class)
	public void transionTest6() throws IOException {
		
		log.info("transionTest6()테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("트랜잭션6-1");
		boardVO.setbName("트랜잭션6-1");
		boardVO.setbTitle("트랜잭션6-1");
		
		boardMapper.insertBoard(boardVO);
		
		//IOException도 실행이됨 트랜잭션 취소 안됨 이유는 뭘까?! 
		throw new IOException("IOException for rollback");
	}
}
