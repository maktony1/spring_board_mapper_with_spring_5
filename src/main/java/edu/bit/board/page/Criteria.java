package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString	//lombok-toString()을 오버라이드하는 롬복의 toString().각 필드와 함께 클래스 이름을 순서대로 쉼표로 구분하여 인쇄합니다.
public class Criteria {
	//페이징 처리를 위해서는 페이지 번호와 한 페이지당 몇개의 데이터를 보여줄것인지 결정해야함
	private int pageNum;	//페이지 번호
	private int amount;		//페이지당 몇개의 데이터를 보여줄것인지?
	
	public Criteria() {
		this(1,10);	//1페이지 10개로 기본값 지정.
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
