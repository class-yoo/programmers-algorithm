package p20210201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {

	int[] courseCounts;
	Map<String, Integer> map;
	int max;

	public String[] solution(String[] orders, int[] course) {
		List<String> list = new ArrayList<>();
		courseCounts = new int[course.length];
		
		for (int i = 0; i < orders.length; i++) {
			char [] charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			String result = String.valueOf(charArr);
			orders[i] = result;
		} 
		
		for (int j = 0; j < course.length; j++) {
			this.map = new HashMap<String, Integer>();
			this.max = 0;
			for (int i = 0; i < orders.length; i++) {
				String[] foods = orders[i].split("");
				boolean[] isUsed = new boolean[foods.length];
				for (int l = 0; l < foods.length; l++) {
					isUsed[l] = true;
					makeCouse(course[j], isUsed, l, foods[l], foods);
					isUsed[l] = false;
				}
				
			}

			for (String key : map.keySet()) {
				if (max >=2 && map.get(key) == max) {
					list.add(key);
				}
			}
		}

		Collections.sort(list);
		String[] answer = new String[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	public void makeCouse(int menuLimit, boolean[] isUsed, int foodIndex, String tempCourse, String[] foods) {

		if (menuLimit == tempCourse.length()) {
			if (map.containsKey(tempCourse)) {
				int replaceNumber = map.get(tempCourse) + 1;
				map.put(tempCourse, replaceNumber);
				max = Math.max(max, replaceNumber);
			} else {
				map.put(tempCourse, 1);
			}
		} else {
			for (int i = foodIndex+1; i < foods.length; i++) {
				if (isUsed[i] == false) {
					isUsed[i] = true;
					makeCouse(menuLimit, isUsed, i, tempCourse+foods[i], foods);
					isUsed[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		메뉴리뉴얼 메뉴리뉴얼 = new 메뉴리뉴얼();
		String [] result = 메뉴리뉴얼.solution(
				new String []{"XYZ", "XWY", "WXA"}, 
				new int [] {2, 3, 4}
				);
//		String [] result = 메뉴리뉴얼.solution(
//				new String []{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, 
//				new int [] {2, 3, 5	}
//				);
//		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
