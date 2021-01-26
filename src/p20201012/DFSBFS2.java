package p20201012;

public class DFSBFS2 {

	public int solution(int n, int[][] computers) {
		int count = 0;
		boolean[] isCheckdArr = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (isCheckdArr[i] == false) {
				checkPC(computers, isCheckdArr, i);
				count++;
			}
		}
		return count;
	}

	public void checkPC(int[][] computers, boolean[] isCheckdArr, int index) {
		if (isCheckdArr[index] == true)
			return;
		isCheckdArr[index] = true;

		for (int i = 0; i < computers[index].length; i++) {
			if (index == i)
				continue;
			if (computers[index][i] == 1) {
				checkPC(computers, isCheckdArr, i);
			}
		}

		return;
	}

	public static void main(String[] args) {
		DFSBFS2 dfsbfs2 = new DFSBFS2();
		System.out.println(dfsbfs2.solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));

	}
}
