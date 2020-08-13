package edu.bit.board.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeptEmpVO {  	//1대N   Dept=1   Emp=N
	int deptno;				//NOT NULL NUMBER(2)
	String dname;  			//VARCHAR2(14)
	String loc;				//VARCHAR2(13)
	
	List<EmpVO> empList;
	
}
