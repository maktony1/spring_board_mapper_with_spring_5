package edu.bit.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BoardController {
//@Autowired 

	@Inject
	private BoardService service;
	
//	@Inject
//	public BoardController(BoardService service) {
//		this.service = service;
//	}
	 @GetMapping("/list3")
	 public void list3(Criteria cri, Model model) {	
		 log.info("list3");
		 log.info(cri);
		 model.addAttribute("list", service.getList(cri));	
		 
		 int total = service.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageDTO(cri,total));	
	 }
	
	
	
	
	
	
	
	
	@RequestMapping("/rectangleArea")
	public void recArea(Model model) {
		System.out.println("model :" +model);
		log.info("rectArea");
	}
	@GetMapping("/rectangle")
	public String rectangle() {
		log.info("rectangle");
		return "rectangle";
	}
	@GetMapping("/jqueryList")
	public void jqueryList(Model model) {
		log.info("jqueryList");
		model.addAttribute("list", service.getList());
	}
	
		 
		@GetMapping("/list")
		public void list(Model model) {
			log.info("list");
			model.addAttribute("list", service.getList());
		}
		 


	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		
		model.addAttribute("content_view", service.get(boardVO.getbId()));
		return "content_view";
	}
	
	
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		log.info("modify");
		
		service.modify(boardVO);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("write_view");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) throws Exception{
		log.info("write()");
		service.insertBoard(boardVO);
		return "redirect:list";
	}
	
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO,Model model) {
		log.info("delete");
		
		service.remove(boardVO.getbId());
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view");
		model.addAttribute("reply_view",service.get(boardVO.getbId()));
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) throws Exception{
		log.info("reply()");
		
		service.writeReply(boardVO);
		
		return "redirect:list";
	}
	
	//ajax 부분
	@GetMapping("/ajax/List")
	public String ajaxList() {
		log.info("ajaxList()");
		return "ajaxList";
	}
	@GetMapping("/ajax/List2")
	public String ajaxList2() {
		log.info("ajaxList2()");
		return "ajaxList2";
	}
	@GetMapping("/ajax/List3")
	public String ajaxList3() {
		log.info("ajaxList3()");
		return "ajaxList3";
	}
	@GetMapping("/ajax/List4")
	public String ajaxList4() {
		log.info("ajaxList4()");
		return "ajaxList4";
	}
	
}
	//	@Autowired
//	private BoardService service;
//	
//	@GetMapping("/list")
//	public String list(Model model) {
//		log.info("list");
//		model.addAttribute("list", service.getList());
//		return "list";
//	}
