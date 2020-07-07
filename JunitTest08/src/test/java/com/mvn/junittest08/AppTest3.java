package com.mvn.junittest08;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AppTest3 {

	private String expect;
	private String result;
	

	@Parameters
	public static Collection<String[]> getTestParameter(){
		return Arrays.asList(new String[][]{
			{"01055067762", "010-5506-7762"},
			{"123456789", "123qweasd456qwesad-;789"}
		});
	}
	
	public AppTest3(String expect, String result) {
		super();
		System.out.println("testparameter() 생성");
		this.expect = expect;
		this.result = result;
		
	}

	// 실습 3
	@Test
	public void test() {
		App app = new App();
		assertEquals(expect, app.toNumber(result));
		System.out.println("통과  : " + expect + " : "  + result);
	}

}
