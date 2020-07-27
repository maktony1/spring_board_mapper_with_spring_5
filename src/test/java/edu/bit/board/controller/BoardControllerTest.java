package edu.bit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {

	@Setter(onMethod_ = { @Autowired})
	private WebApplicationContext ctx;
	
//@ 컨트롤러 하면 이 컨트롤러 객체를 어디에 가지고 있냐 아이오씨 컨테이너에 집어넣고 관리한다 근데 우리눈에 안보임 디스패쳐서블릿 생성될때 알아서 
//	생성됨 WebApplicationContext이 안에 핸들러매핑까지해서 얘가 다 가지고 있음

	private MockMvc mockMvc;
//MockMvc란?
//	 실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서 애플리케이션 서버에 배포하지 않고 스프링 MVC 동작을 재현할 수 있는 클래스를 의미
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/list"))
		.andExpect(status().isOk()) //응답 검증 
		.andDo(print())
		.andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}
}
//보이드 있으면 리턴값이 모델엔 뷰에서 리스트.jsp 리스트로 갑니다.