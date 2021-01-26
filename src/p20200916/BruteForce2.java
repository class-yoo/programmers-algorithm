package p20200916;

public class BruteForce2 {

	public int[] solution(int brown, int yellow) {

		int tempYellowHeight = 1;
		int tempYellowWidth = 1;

		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i == 0) {
				tempYellowWidth = yellow / i;
				tempYellowHeight = yellow / tempYellowWidth;
				if ((tempYellowHeight + 2) * (tempYellowWidth + 2) - yellow == brown) {
					break;
				}
			}
		}

		return new int[] { tempYellowWidth + 2, tempYellowHeight + 2 };
	}

	public static void main(String[] args) {
		BruteForce2 bruteForce2 = new BruteForce2();
		System.out.println(bruteForce2.solution(24, 24).toString());
	}
}
