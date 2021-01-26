package p20201126;

public class 일이사나라의숫자 {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(n % 3 == 0 ? 4 : n % 3);
			n = (n - 1) / 3;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		일이사나라의숫자 otf = new 일이사나라의숫자();

		System.out.println(otf.solution(11));
	}
}
