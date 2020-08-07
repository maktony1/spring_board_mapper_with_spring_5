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
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception{
		
		log.info("/member/logout");
		
		session.invalidate(); //GC(가비지컬렉터가 지움)
							  //delete 안쓰고 invalidate 쓰는이유 
							  //delete 로 못지움 자기가 못지우기 때문에
							  //invalidate로 지울 대상을 GC에게 알려준다고 생각 ㄱ
		return "redirect:/";
	}
	
	
}
/**
 * 데이터 베이스에 추가하기~~~~~~~ 
 */
/*
create table users(
		username varchar2(50) not null primary key,
		password varchar2(100) not null,
		enabled char(1) DEFAULT '1'
	);
	create table authorities (
		username varchar2(50) not null,
		authority varchar2(50) not null,
		constraint fk_authorities_users foreign key(username) references users(username)
	);
	create unique index ix_auth_username on authorities (username,authority);

	commit;

	insert into users (username,password) values('user','user');
	insert into users (username,password) values('member','member');
	insert into users (username,password) values('admin','admin');

	commit;

	insert into AUTHORITIES (username,AUTHORITY) values('user','ROLE_USER');
	insert into AUTHORITIES (username,AUTHORITY) values('member','ROLE_MANAGER');
	insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_MANAGER');
	insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_ADMIN');

	commit;

	select * from users;
	select * from authorities;
*/