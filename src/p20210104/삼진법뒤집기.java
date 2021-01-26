package p20210104;

public class 삼진법뒤집기 {
	public int solution(int n) {
		int answer = 0;
		long number = 0, pow = 0;

		while (n > 0) {
			number = number * 10 + n % 3;
			n /= 3;
		}

		while (number > 0) {
			answer += (int) (Math.pow(3, pow++)) * (number % 10);
			number /= 10;
		}

		return answer;
	}

	public static void main(String[] args) {
		삼진법뒤집기 삼진법뒤집기 = new 삼진법뒤집기();
		System.out.println(삼진법뒤집기.solution(0));
	}
}
