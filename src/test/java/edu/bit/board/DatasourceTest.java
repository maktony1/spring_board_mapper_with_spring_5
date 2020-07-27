package edu.bit.board;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class) //이게 IOC컨테이너 만드는거임
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //저 안에다가 이걸 읽어들여라
@Log4j
public class DatasourceTest { 

	
	@Autowired //or @Inject 둘중하나  
	DataSource dataSource;
	
	@Test
	public void testdatasource() {
		System.out.println(dataSource);
	}
	
}
