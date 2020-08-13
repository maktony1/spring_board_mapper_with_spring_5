package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.DeptEmpVO;
import edu.bit.board.vo.EmpVO;

public interface EmpService {
	
	List<EmpVO> getList();
	
	DeptEmpVO deptEmpList(int deptno);
}
