package edu.bit.board.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //저 안에다가 이걸 읽어들여라
@Log4j
public class boardMapperTest {

	//주입 3가지 방식( 생성자, setter, 필드에 다이렉트)
	
	
//	//필드에 다이렉트 ( 근데 이건 좋지 않은 방법이다 ) 생성자나 setter를 통해서 넣어야지~ 제대로된 주입 생성자 setter
//	@Autowired
//	private BoardMapper boardMapper;
	
	
	
	@Setter(onMethod_ = @Autowired)//보드메퍼에대한 세터 함수를 생성합니다.
	private BoardMapper boardMapper;
	//dao 커넥션풀을 가지고와서 접속을 해야하니깐 그 내용을 가져와야함 
	//root-context.xml 해석 가능해야함 
	@Test
	public void testBoardMapper() {
		log.info(boardMapper);
	}
	@Test
	public void testBoardMapperList() {
		List<BoardVO> list = boardMapper.getList();
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getbContent());
			log.info(boardVO.getbId());
		}
	}
}
