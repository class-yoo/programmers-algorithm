package level3.p20200127;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {

	int N;
	int number;
	int answer;
	Set<Integer> alreadyCalCheckSet;

	public int solution(int N, int number) {
		this.N = N;
		this.number = number;
		this.answer = 9;
		this.alreadyCalCheckSet = new HashSet<>();

		dfs(1, N);

		return this.answer > 8 ? -1 : this.answer;
	}

	public void dfs(int count, int calNum) {

		if (count >= answer)
			return;
		if (this.alreadyCalCheckSet.contains(calNum))
			return;
		if (calNum == this.number) {
			this.answer = Math.min(this.answer, count);
			return;
		}

		this.alreadyCalCheckSet.add(calNum);
		int copyNumber = this.N;

		for (; count < answer -1; count++) {
			dfs(count + 1, copyNumber + calNum);
			dfs(count + 1, copyNumber - calNum);
			dfs(count + 1, copyNumber * calNum);
			dfs(count + 1, copyNumber / calNum);
			dfs(count + 1, calNum + copyNumber);
			dfs(count + 1, calNum - copyNumber);
			dfs(count + 1, calNum * copyNumber);
			dfs(count + 1, calNum / copyNumber);

			copyNumber = copyNumber * 10 + this.N;
		}
	}
	
	public static void main(String[] args) {
		N으로표현 n으로표현 = new N으로표현();
		System.out.println(n으로표현.solution(5, 12));
	}
}
