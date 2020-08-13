package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.DeptEmpVO;
import edu.bit.board.vo.EmpVO;

public interface EmpMapper {

	//List<BoardVO> getList(); 이렇게 되어잇엇음
	List<EmpVO> getList(); 
	
	DeptEmpVO selectDeptEmp(int deptno);
}
