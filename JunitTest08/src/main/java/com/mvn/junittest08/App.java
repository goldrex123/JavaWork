package com.mvn.junittest08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	App app = new App();
        System.out.println( "Hello World!" );
        System.out.println(app.toNumber("01110as6607qweqwe5534").toString());
    }
    
    // 실습 1
    public void sortArr(int [] arr) {
    	Arrays.sort(arr);
    }
    
    // 실습 2
    public int max(int [] arr) {
    	Arrays.sort(arr);
    	
    	int max = arr[arr.length-1];
    	
    	return max;
    }
    public int min(int [] arr) {
    	Arrays.sort(arr);
    	
    	int min = arr[0];
    	
    	return min;
    }
    
    // 실습 3
    public String toNumber(String str){
    	String result = "";
    	
    	char[] c = str.toCharArray();
    	
    	for (int i = 0; i < c.length; i++) {
			if(c[i] >= '0' && c[i] <= '9') {
				result += c[i];
			}
		}
    	
    	return result;
    }
}
