package p20201217;

public class 쿼드압축후개수세기 {
	public int[] solution(int[][] arr) {

		int zeroCount = 0;
		int oneCount = 0;
		int length = arr.length;

		int dp [][] = new int [length+1][length+1];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (arr[i][j] == 0)
					zeroCount++;
			}
		}
		
		oneCount = length * length - zeroCount;

		int N = 0;
		int pressCount = 1;
		
		for (int i = 2; i < length; i *= 2) {
			int number = (int) Math.pow(2, pressCount);
			for (int j = 2; j < length; j = j + i) {
				if (arr[i][j] == arr[i-number][j] &&
						arr[i][j] == arr[i][j-number] &&
						arr[i][j] == arr[i-number][j-number] &&
						pressCount == arr[i][j]) {
					
					dp[i][j] = pressCount + 1;
				}
			}
			pressCount++;
		}

		return new int[] { zeroCount, oneCount };
	}

	public static void main(String[] args) {
		쿼드압축후개수세기 쿼드압축후개수세기 = new 쿼드압축후개수세기();

		쿼드압축후개수세기.solution(new int[][] { 
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 1, 1, 1, 1 }, 
			{ 0, 1, 0, 0, 1, 1, 1, 1 }, 
			{ 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 0, 0, 0, 0, 1, 0, 0, 1 }, 
			{ 0, 0, 0, 0, 1, 1, 1, 1 } });
	}
}
