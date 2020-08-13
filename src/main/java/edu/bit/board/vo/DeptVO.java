package edu.bit.board.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeptVO {
	int deptno;		//NOT NULL NUMBER(2)
	String dname;   //VARCHAR2(14)
	String loc;		//VARCHAR2(13)
}