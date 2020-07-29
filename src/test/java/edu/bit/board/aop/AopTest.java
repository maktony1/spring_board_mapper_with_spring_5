package edu.bit.board.aop;

import javax.inject.Inject;

import org.apache.ibatis.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.service.BoardService;
import lombok.extern.log4j.Log4j;



@RunWith(SpringRunner.class) //이게 IOC컨테이너 만드는거임
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/aop-context.xml"}) //저 안에다가 이걸 읽어들여라
@Log4j
public class AopTest {

	@Inject
	private BoardService service; 
	
	@Test
	public void testServiceAop() {
		log.info("리스트 시작");
		log.info(service.getList());
		log.info("리스트 끝");
//		Log.info(service.getList());
	}
}
