package p20200910;

public class Problem2 {
	public int[] solution(int n) {
		int arrLength = 0;

		for (int i = 1; i <= n; i++) {
			arrLength += i;
		}

		int[] answer = new int[arrLength];

		int height = 0;
		int insertNumber = 1;
		int index = 0;
		int directionSwitch = 0;
		int limitMoveNum = 1; // 1층 부터 시작

		while (true) {

			if (directionSwitch == 0) {
				index = index + height++;
				answer[index] = insertNumber++;

				if (limitMoveNum++ == n) {
					limitMoveNum = 1;
					directionSwitch = 1;
					n = n - 1;
					if (n == 0)
						break;
				}

			}

			if (directionSwitch == 1) {
				index++;
				answer[index] = insertNumber++;

				if (limitMoveNum++ == n) {
					limitMoveNum = 1;
					directionSwitch = 2;
					n = n - 1;
					if (n == 0)
						break;
				}
			}

			if (directionSwitch == 2) {
				index = index - height--;
				answer[index] = insertNumber++;

				if (limitMoveNum++ == n) {
					limitMoveNum = 1;
					directionSwitch = 0;
					n = n - 1;
					if (n == 0)
						break;
				}
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		Problem2 Problem2 = new Problem2();
		int arr[] = Problem2.solution(5);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
