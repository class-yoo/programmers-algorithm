package p20210104;

import java.util.ArrayList;

public class 프렌즈4블록 {
	
	ArrayList<Boolean>[] gameScord;
	String board[];
	ArrayList<Character>[] arr;
	int height;
	int width;
	boolean isExist4Block = true;

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		this.board = board;
		this.height = m;
		this.width = n;
		this.gameScord = new ArrayList[n];
		this.arr = new ArrayList[n]; // n = 너비 , m = 높이

		initGame();

		while (isExist4Block) {
			answer += removeBlock();
			search4Block();
		}

		return answer;
	}

	private int removeBlock() {
		int count = 0;
		if (isExist4Block) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].size(); j++) {
					if (gameScord[i].get(j) == true) {
						arr[i].remove(j);
						gameScord[i].remove(j--);
						count++;
					}
				}
			}
		}
		return count;
	}

	public void initGame() {
		for (int i = 0; i < width; i++) { // 너비
			arr[i] = new ArrayList<>();
			gameScord[i] = new ArrayList<>();
			for (int j = height-1; j >= 0; j--) { // 높이
				arr[i].add(board[j].charAt(i));
				gameScord[i].add(false);
			}
		}
	}

	private void search4Block() {
		isExist4Block = false;
		for (int i = 0; i < arr.length - 1; i++) { // 너비
			for (int j = 0; j < arr[i].size()-1; j++) { // 높이
				char temp = arr[i].get(j);
				if (arr[i + 1].size() <= j+1) break;
				if (temp == arr[i + 1].get(j) && 
						temp == arr[i].get(j + 1) && 
						temp == arr[i + 1].get(j + 1)) {
					gameScord[i].set(j, true);
					gameScord[i+1].set(j, true);
					gameScord[i].set(j+1, true);
					gameScord[i+1].set(j+1, true);
					isExist4Block = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		프렌즈4블록 프렌즈4블록 = new 프렌즈4블록();
		int result2 = 프렌즈4블록.solution(6, 6, new String [] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
		
		System.out.println(result2);
	}
}
