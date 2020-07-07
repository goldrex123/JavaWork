package com.mvn.junittest08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class AppTest {

	// 실습1
    @Test
    public void test1()
    {
    	App app = new App();
    	int [] arr = {1,2,3,4,5};
    	
    	int [] arr1 = {2,1,4,5,3};
    	int [] arr2 = {5,1,2,3,4};
    	int [] arr3 = {4,5,1,2,3};
    	int [] arr4 = {3,4,5,1,2};
    	int [] arr5 = {2,3,4,5,1};
    	
    	app.sortArr(arr1);
    	app.sortArr(arr2);
    	app.sortArr(arr3);
    	app.sortArr(arr4);
    	app.sortArr(arr5);
    	
    	assertArrayEquals(arr, arr1);
    	assertArrayEquals(arr, arr2);
    	assertArrayEquals(arr, arr3);
    	assertArrayEquals(arr, arr4);
    	assertArrayEquals(arr, arr5);
    }
    

	// 실습2
    @Test
    public void test2() {
    	App app = new App();
    	String src = "TEST/report.txt";
		String dst = src;
    	
    	String minRecord = "";
    	String maxRecord = "";
    	
    	int [] arr = {2,1,5,4,3};
    	
    	int [] arr2 = {6,7,8,9,10};
    	
    	int [] arr3 = {11,13,14,15,12};
    	
    	int min = app.min(arr);
    	int max = app.max(arr);
    	assertEquals(1, min);
    	assertEquals(5, max);
    	
    	minRecord += min + ", ";
    	maxRecord += max + ", ";
    	
    	min = app.min(arr2);
    	max = app.max(arr2);
    	assertEquals(6, min);
    	assertEquals(10, max);
    	
    	minRecord += min + ", ";
    	maxRecord += max + ", ";
    	
    	min = app.min(arr3);
    	max = app.max(arr3);
    	assertEquals(11, min);
    	assertEquals(15, max);
    	
    	minRecord += min + "\n";
    	maxRecord += max + " ";
    	
		try (	
			FileWriter fw = new FileWriter(dst); 
			FileReader fr = new FileReader(src);) {
			fw.write("min = " + minRecord); // 저장은 시스템 인코딩 상태에 따라 저장됨.
							// UTF-8 인코딩의 경우, 한글은 글자당 3바이트, 영문은 1바이트로 저장
			fw.write(""
					+ "");
			fw.write("max = "  + maxRecord);
			fw.flush(); //write() 호출 후에는 flush() 하여 출력 버퍼의 데이터가 완전히 출력 되도록 한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}









