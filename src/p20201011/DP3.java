package p20201011;

public class DP3 {
	int minNumber = Integer.MAX_VALUE;
	int minNumberCount = 0;

	public int solution(int m, int n, int[][] puddles) {

		int map[][] = new int[n][m];

		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = 1;
		}

		move(map, 0, 0, 0);

		return minNumberCount % 1000000007;
	}

	public void move(int[][] map, int m, int n, int count) {

		if (minNumber < count)
			return;
		if (map.length <= n || map[0].length <= m)
			return;
		if (map[n][m] == 1)
			return;

		if (map.length - 1 == n && map[0].length - 1 == m) {
			if (minNumber > count) {
				minNumber = count;
				minNumberCount = 1;
			} else if (minNumber == count) {
				minNumberCount++;
			}
			return;
		}

		move(map, m + 1, n, count + 1);
		move(map, m, n + 1, count + 1);

	}

	public static void main(String[] args) {
		DP3 dp3 = new DP3();

		System.out.println(dp3.solution(5, 5, new int[][] { { 2, 1 }, { 4, 3 }, { 2, 2 } }));
	}
}
