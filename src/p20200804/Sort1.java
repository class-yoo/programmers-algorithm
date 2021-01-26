package p20200804;

import java.util.Arrays;

public class Sort1 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int tempArr[] = new int[commands[i][1] - commands[i][0] + 1];
			int tempArrIndex = 0;
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				tempArr[tempArrIndex++] = array[j];
			}
			Arrays.sort(tempArr);

			answer[i] = tempArr[commands[i][2] - 1];
		}

		return answer;
	}

	public static void main(String[] args) {

		Sort1 sort1 = new Sort1();
		int arr1[] = { 1, 5, 2, 6, 3, 7, 4 };
		int arr2[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		sort1.solution(arr1, arr2);
	}
}
