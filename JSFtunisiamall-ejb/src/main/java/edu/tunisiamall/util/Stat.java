package edu.tunisiamall.util;

import java.math.BigDecimal;

public class Stat {

	private int month;
	private BigDecimal val;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public BigDecimal getVal() {
		return val;
	}
	public void setVal(BigDecimal val) {
		this.val = val;
	}
	public Stat(int month, BigDecimal val) {
		super();
		this.month = month;
		this.val = val;
	}
	
}
