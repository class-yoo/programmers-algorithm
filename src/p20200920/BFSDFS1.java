package p20200920;

public class BFSDFS1 {

	public int dfs(int[] numbers, int target, int number, int index) {

		if (index >= numbers.length) {
			if (number == target)
				return 1;

			return 0;
		}

		return dfs(numbers, target, number + numbers[index], index+1)
				+ dfs(numbers, target, number - numbers[index], index+1);
	}

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
}
