package p20201221;

import java.util.Arrays;
import java.util.Comparator;

public class 튜플2 {
	public int[] solution(String s) {
		s = s.replace("}", "").replace("{", "");
		
		String[] arr = s.split(","); 
		int SortedArrLength = 0;

		int countArr[][] = new int[100001][2]; 

		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			if (countArr[num][0] != 0 ) {
				countArr[num][1]++;	
			} else {
				countArr[num][0] = num;
				countArr[num][1]++;
				SortedArrLength++;
			}
		}

		Arrays.sort(countArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o2, int[] o1) {
				return o1[1] - o2[1];
			}
		});

		int answer[] = new int[SortedArrLength];
		for (int i = 0; i < SortedArrLength; i++) {
			answer[i] = countArr[i][0]; 
		}

		return answer;
	}

	public static void main(String[] args) {

		튜플2 튜플2 = new 튜플2();

		int result[] = 튜플2.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
