package edu.bit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class LoginController {

	private LoginService loginService;
	
	@GetMapping("/")
	public String home() {
		log.info("home");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		log.info("post login");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserVO login = loginService.loginUser(id,pw);
		
		if(login == null) {
			session.setAttribute("user", null);
			// Spring3 에서 제공하는 RedirectAttributes를 사용하면 redirect post 구현이 가능하다.
			// 하지만 일회성 이고, 새로고침하면 날라가는 데이터라 사용목적에 따라서 사용/불가능 판단을 해야함
			rttr.addFlashAttribute("msg",false);
		} else {
			session.setAttribute("user", login);
		}
		return "redirect:/";
		
	}
}
