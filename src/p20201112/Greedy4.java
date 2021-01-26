package p20201112;

import java.util.Arrays;

public class Greedy4 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int maxNumBotIdx = people.length - 1;
		for (int i = 0; i <= maxNumBotIdx; i++) {
			for (int j = maxNumBotIdx; j >= i; j--) {
				maxNumBotIdx--;
				answer++;
				if (people[i] + people[j] > limit)
					continue;
				else
					break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Greedy4 greedy4 = new Greedy4();
		System.out.println(greedy4.solution(new int[] { 50, 70, 80 }, 100));

		int i;
		for (i = 0; i < args.length; i++) {

		}

		int temp = 0;

	}
}
