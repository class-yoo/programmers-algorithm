package p20201026;

public class DP3 {
	int[][] map;
	boolean[][] puddlesMap;

	public int solution(int m, int n, int[][] puddles) {

		this.map = new int[n][m];
		this.puddlesMap = new boolean[n][m];
		map[n-1][m-1] = 1;

		for (int i = 0; i < puddles.length; i++) {
			this.puddlesMap[puddles[i][1] - 1][puddles[i][0] - 1] = true;
		}

		for (int i = n - 2; i >= 0; i--) {
			if (this.puddlesMap[i][m-1] == true) break;
			this.map[i][m-1] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			if (this.puddlesMap[n-1][i] == true) break;
			this.map[n - 1][i] = 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				if (this.puddlesMap[i][j] == false) {
					this.map[i][j] = this.map[i + 1][j] + this.map[i][j + 1];
				}
			}
		}

		return (this.map[0][0]) % 1000000007;
	}

	public static void main(String[] args) {

		DP3 dp3 = new DP3();

		System.out.println(dp3.solution(5, 5, new int[][] { { 2, 1 }, { 4, 3 }, { 2, 2 }, { 5, 4 } }));
//		System.out.println(dp3.solution(4, 3, new int[][] { { 2, 2 } }));

	}
}
