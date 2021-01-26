package p20201202;

public class 삼각달팽이 {
	public int[] solution(int n) {

		int direction = 0, insertNumber = 1;
		int currentHeight = 0, currentIndex = 0;
		int maxNumber = n * (n + 1) / 2;

		int[] answer = new int[maxNumber];

		while (insertNumber <= maxNumber) {
			for (int i = 0; i < n; i++) {
				direction = direction % 3;

				switch (direction) {
				case 0:
					currentIndex += currentHeight++;
					break;
				case 1:
					currentIndex++;
					break;
				case 2:
					currentIndex -= currentHeight--;
					break;
				}

				answer[currentIndex] = insertNumber++;
			}

			direction++;
			n--;
		}

		return answer;
	}

	public static void main(String[] args) {
		삼각달팽이 triangle = new 삼각달팽이();
		int result[] = triangle.solution(4);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
