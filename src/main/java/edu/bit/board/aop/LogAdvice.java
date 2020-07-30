package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	
//	@Before("within(edu.bit.board.service.BoardServiceImpl.getList())") <--이건 왜 되는거지 근데 아래 *과 동일하게됨	
	@Before("within(edu.bit.board.service.*)")
	public void printLogging() {  
		System.out.println("공통기능 - 프린트 로그");
	}

}
