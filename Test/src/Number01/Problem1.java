package Number01;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		String s = "a B ";
		int n = 1;
		char c[] = s.toCharArray();
		int num = 0;
        boolean isUpper = false;
        
		for(int i = 0;i<c.length;i++){
            if(c[i] >= 'a' && c[i] <='z'){
                c[i] = (char)(c[i] + n);
            } else if(c[i] >= 'A' && c[i] <='Z'){
                c[i] = (char)(c[i] + n);
                isUpper = true;
            }
                
            if(!Character.isLetter(c[i])){
                if(isUpper){
                    num = c[i]-'Z'-1;
                    c[i] = 'A';
                    c[i] = (char)(c[i]+num);
                } else {
                    num = c[i]-'z'-1;
                    c[i] = 'a';
                    c[i] = (char)(c[i]+num);
                }
            }
            isUpper = false;
        }
		
	}	
}
