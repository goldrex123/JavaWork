package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		String[] words = C.ALICE30.trim().toLowerCase().split("[*_,.\\\"\\'`!?;:-[(][)]\\s]+");
		ArrayList<WordFreq> list = new ArrayList<WordFreq>();

		// 발생빈도
		for (int i = 0; i < words.length; i++) {
			Integer v = hmap.get(words[i]); // arr[i] 가 key
			if (words[i].length() != 1) {
				if (v == null) { // 기존에 해당key 값이 없다면
					hmap.put(words[i], 1); // 등장횟수 1
				} else {
					hmap.put(words[i], v + 1); // 기존 등장횟수에 +1 증가
				}
			}
		}
		
		Set<String> keySet = hmap.keySet();
		Iterator<String> itr = keySet.iterator();
		for(int i = 0 ; i<hmap.size(); i++) {
			String key = itr.next();		
			WordFreq wf = new WordFreq(key, hmap.get(key));
			list.add(wf);
		}
		
		Collections.sort(list);
		Iterator<WordFreq> itr2 = list.iterator();
		String i = "1";
		while(itr2.hasNext()) {
			System.out.println(i + " "+ itr2.next());
			i = Integer.parseInt(i) + 1 + "";
		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

class WordFreq implements Comparable<WordFreq> {
	String name;
	int point;

	public WordFreq(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}

	public String toString() {
		return this.name + ":" + this.point + "개";
	}
	// compareTo() 메소드는 매개변수 객체를 '자신'과 비교하여 작으면 음수, 같으면 0, 크면 양수를 리턴한다.
	@Override
	public int compareTo(WordFreq o) {

		// 점수 오름차순 정렬
//		if(o.point > this.point) return -1; //내가 더 작으면 음수
//		if(this.point > o.point) return 1; //내가 더 크면 양수
//		return 0; // 같으면 0리턴

		// 점수 내림차순 정렬
		if (o.point < this.point)
			return -1; // 내가 더 크면 음수
		if (this.point < o.point)
			return 1; // 내가 더 작으면 양수
		return 0; // 같으면 0리턴

	}
} // end class
