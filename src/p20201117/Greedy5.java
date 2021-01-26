package p20201117;

public class Greedy5 {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		int[] arr = new int[n];

		for (int i = 0; i < costs.length; i++) {
			int max = Math.max(costs[i][0], costs[i][1]);
			arr[max] = arr[max] == 0 ? 
					costs[i][2] : Math.min(arr[max], costs[i][2]);
		}

		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}

	public static void main(String[] args) {
		Greedy5 greedy5 = new Greedy5();
		int result = greedy5.solution(5,
				new int[][] {{0,1,1},{0,3,2},{1,2,5},{1,3,3},{1,4,3},{2,4,6},{3,4,4}});
		System.out.println(result);
	}
}