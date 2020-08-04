package edu.bit.board.vo;

import org.springframework.stereotype.Repository;


@Repository
public class RectVO {
	private double width;
	private double height;

	public RectVO() {
	}

	
	
	
	
	public RectVO(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	
	
	
	
	
	public double getArea() {
		return width*height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	
	
}
