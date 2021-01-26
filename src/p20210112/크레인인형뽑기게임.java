package p20210112;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	public int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer>[] arr = new Stack[board.length];
		int answer = 0;
		
		for (int i = 0; i < board[0].length; i++) {
			arr[i] = new Stack<>();
			for (int j = 0; j < board.length; j++) {
				arr[i].push(board[j][i]);
			}
		}

		for (int i = 0; i < moves.length; i++) {
			int pickNum = arr[moves[i]-1].pop();
			if (stack.isEmpty() || stack.peek() != pickNum) {
				stack.push(pickNum);
			} else {
				stack.pop();
				answer++;
			}
		}

		return answer*2;
	}
	
	public static void main(String[] args) {
		크레인인형뽑기게임 크레인인형뽑기게임 = new 크레인인형뽑기게임();
		
		int result = 크레인인형뽑기게임.solution(
				new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, 
				new int [] {1,5,3,5,1,2,1,4});
		
		System.out.println(result);
	}
}
