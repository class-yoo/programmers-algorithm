package p20201221;

import java.util.ArrayList;

public class 튜플 {
	public int[] solution(String s) {
		ArrayList<Integer> list = new ArrayList<>(); 
		s = s.substring(2, s.length() - 2);
		String [] arr  = s.split("},{");
		int countArr [] = new int [100001];
		
		for (int i = 0; i < arr.length; i++) {
			String [] arr2 = arr[i].split(",");
			for (int j = 0; j < arr2.length; j++) {
				int num = Integer.parseInt(arr2[j]);
				if (countArr[num] == 0) {
					list.add(num);
					countArr[num] = 1;
				}
			}
		}
		
		int answer [] = new int [list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		튜플 튜플= new 튜플();
		
		int result [] = 튜플.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
}
