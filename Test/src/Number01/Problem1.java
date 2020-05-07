package Number01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		Problem1 pb1 = new Problem1();
		String[] str =  {"BACDE", "CBADF", "AECB", "BDA"};
		pb1.solution("CBD", str);
	}	
	
	 public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	        String c[] = skill.split("");
	        List<String> list = new ArrayList<String>();
	        list.addAll(Arrays.asList(c));
	        boolean ga = false;
	        int num;
	        
	        for(int i = 0 ; i < skill_trees.length; i++){
	            ArrayList<String> list2 = new ArrayList<String>();
	            list2.addAll(Arrays.asList(skill_trees[i].split("")));
	            
	            for(int j = 0 ; j< list2.size(); j++){
	                
	                if(!list.contains(list2.get(j))){
	                    list2.remove(j);
	                    j--;
	                }
	            }
	            
	            for(num = 0 ; num < list2.size(); num++){
	                if(!(list.indexOf(list2.get(num))==num)) break;
	            }
	            if(num == list2.size()) ga = true;
	            num = 0;
	            if(ga) answer++;
	            ga = false;
	        }
	        System.out.println(answer);
	        return answer;
	    }	
}
