package com.lec.spring;

import ex2_1.OperatorBean;

public class PlusOp implements OperatorBean {
	
	int operand1;
	int operand2;

	public PlusOp() {
		super();
	}

	public PlusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public int doOperator() {
		return operand1 + operand2;
	}

}
