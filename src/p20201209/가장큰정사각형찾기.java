package p20201209;

public class 가장큰정사각형찾기 {

	public int solution(int[][] board) {

		int max = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i - 1 < 0 || j - 1 < 0) {
					max = Math.max(max, board[i][j]);
					continue;
				}
				
				if (board[i - 1][j - 1] > 0 && board[i - 1][j] > 0 && board[i][j - 1] > 0 && board[i][j] > 0) {

					board[i][j] = (Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1])) + 1;

					max = Math.max(max, board[i][j]);
				}
			}
		}

		return max * max;

	}

	public static void main(String[] args) {
		가장큰정사각형찾기 bigSquare = new 가장큰정사각형찾기();

//		System.out.println(bigSquare.solution(new int [][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
		System.out.println(bigSquare.solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } }));
	}
}
