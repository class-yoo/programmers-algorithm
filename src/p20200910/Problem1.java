package p20200910;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem1 {
	public int[] solution(int[] numbers) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (!list.contains(numbers[i] + numbers[j])) {
					list.add(numbers[i] + numbers[j]);
				}
			}
		}

		int[] answer = new int[list.size()];
		int index = 0;
		for (int number : list) {
			answer[index++] = number;
		}
		Arrays.sort(answer);
		return answer;
	}

	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();
		int arr[] = problem1.solution(new int[] {0,0});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
