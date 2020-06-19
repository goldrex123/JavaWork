package ex3_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		OperatorBean operator = (OperatorBean)ctx.getBean("operator1");
		int value = operator.doOperator();
		System.out.println("결과 : " + value );
		
		ctx.close();
	}

}
