package edu.bit.board.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.service.TransactionService;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class TransactionController {

	private TransactionService transactionService;
	
	@GetMapping("/tran/{num}")
	public void transation(@PathVariable("num") int num) throws SQLException, IOException {
		if(num==1) {
			log.info("transionTest1 테스트");
			transactionService.transionTest1();
		}else if (num==2) {
			log.info("transionTest2 테스트");
			transactionService.transionTest2();
		}else if (num==3) {
			log.info("transionTest3 테스트");
			transactionService.transionTest3();
		}else if (num==4) {
			log.info("transionTest4 테스트");
			transactionService.transionTest4();
		}else if (num==5) {
			log.info("transionTest5 테스트");
			transactionService.transionTest5();
		}else if (num==6) {
			log.info("transionTest6 테스트");
			transactionService.transionTest6();
		}
	}
}