package p20200903;

import java.util.Arrays;

public class Sort2 {

	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			int tempH = citations.length - i;
			if (isHIndex(tempH, i, citations)) {
				answer = tempH;
				break;
			}
		}

		return answer;

	}

	public boolean isHIndex(int tempH, int i, int[] citations) {
		if ((citations[i]) >= tempH) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Sort2 sort2 = new Sort2();
		System.out.println(sort2.solution(new int[] { 3, 0, 6, 1, 5 }));
	}
}
