package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.bit.board.service.EmpService;
import edu.bit.board.vo.DeptEmpVO;
import edu.bit.board.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class EmpController {
	
	@Inject
	private EmpService empService;
	
	
		 
	@GetMapping("emplist")
	public String empList(Model model) {
		log.info("emplist");
		
		List<EmpVO> emplist = empService.getList();
		
		model.addAttribute("emplist",empService.getList());
		
		return "emplist";
	}
	
	@GetMapping("emplist/{deptno}")
	public String listDeptEmp(@PathVariable("deptno") int deptno,Model model) {
		log.info("listDeptEmp");
			
		DeptEmpVO deptEmp = empService.deptEmpList(deptno);
		System.out.println(deptEmp.getEmpList());

		model.addAttribute("emplist",deptEmp.getEmpList());
			
		return "emplist";
	}
}
		 


	
