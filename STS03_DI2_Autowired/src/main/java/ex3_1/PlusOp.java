package ex3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ex3_1.OperatorBean;

public class PlusOp implements OperatorBean {
	
	@Autowired
	@Qualifier("operand1")
	Operand operand1;
	
	@Autowired
	@Qualifier("operand2")
	Operand operand2;
	
	
	public PlusOp() {
		System.out.println("no");
	}

	public void setOperand2(Operand operand2) {
		this.operand2 = operand2;
	}

	@Override
	public int doOperator() {
		return operand1.getValue() + operand2.getValue();
	}

}
