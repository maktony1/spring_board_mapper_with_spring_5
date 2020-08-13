package edu.bit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.mapper.EmpMapper;
import edu.bit.board.vo.DeptEmpVO;
import edu.bit.board.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {
	
	//서비스구현 코딩 아예 안되어있으니 못불러옴 ㅇㅇ 1.EmpMapper추가
	@Inject 
	private EmpMapper mapper;
	
	@Override
	public List<EmpVO> getList() {
		//2.return 값 변경
		//return null;
		return mapper.getList();
	}

	@Override
	public DeptEmpVO deptEmpList(int deptno) {
		//2.return값 변경
		//return null;
		return mapper.selectDeptEmp(deptno);
	}
	
	

	
	
	
}
