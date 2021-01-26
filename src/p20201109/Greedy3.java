package p20201109;

public class Greedy3 {

	public int solution(String name) {
		int answer = 0;
		int tempCount = 0;
		int maxSuccessiveACount = 0;

		for (int i = 0; i < name.length(); i++) {
			char tempChar = name.charAt(i);

			if (tempChar == 'A') {
				if (i >= 1 && i < name.length()) {
					tempCount++;
				}
			} else {
				maxSuccessiveACount = Math.max(maxSuccessiveACount, tempCount);
				tempCount = 0;
			}

			answer += Math.min('Z' - tempChar + 1, tempChar - 'A');
		}

		answer = answer - maxSuccessiveACount + name.length() - 1;
		return answer;
	}

	public static void main(String[] args) {

		Greedy3 greedy3 = new Greedy3();
		System.out.println(greedy3.solution("JACAAN"));
	}
}
