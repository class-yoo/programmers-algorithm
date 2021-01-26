package p20201021;

public class DP1 {

	int limitCount;
	int answerCount = -1;

	public int solution(int N, int number) {
		for (int i = 1; i <= 8; i++) {
			if (answerCount != -1)
				break;

			this.limitCount = i;
			dfs(N, number, 1, N);
		}

		return this.answerCount;
	}

	public void dfs(int N, int number, int count, int makedNumber) {

		if (makedNumber <= 0 || this.limitCount < count) {
			return;
		}

		if (makedNumber == number) {
			this.answerCount = count;
			return;
		}

		dfs(N, number, count + 1, makedNumber + N);
		dfs(N, number, count + 1, makedNumber - N);
		dfs(N, number, count + 1, makedNumber / N);
		dfs(N, number, count + 1, makedNumber * N);
	}

	public static void main(String[] args) {
		DP1 dp1 = new DP1();

		System.out.println(dp1.solution(2, 11));
	}
}
