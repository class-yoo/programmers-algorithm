package level3.p20200127;

public class 합승택시요금 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 100000*200;
		
		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				map[i][j] = i == j ? 0 : 100000*200;
			}
		}

		for (int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] = fares[i][2];
			map[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, map[i][s] + map[i][a]+ map[i][b]);
		}

		return answer;
	}
	
	
	public static void main(String[] args) {
		합승택시요금 합승택시요금 = new 합승택시요금();
		int result = 합승택시요금.solution(6, 4, 6, 2, new int [][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
		
		System.out.println(result);
	}
}
