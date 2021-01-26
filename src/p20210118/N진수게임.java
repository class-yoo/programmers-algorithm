package p20210118;

public class N진수게임 {

	char[] numeralSystemArr = new char[16];

	public String solution(int n, int t, int m, int p) {
		
		int number = 0;
		int index = p - 1;

		for (int i = 0; i < 10; i++) {
			numeralSystemArr[i] = (char) ('0' + i);
		}

		for (int i = 0; i <= 5; i++) {
			numeralSystemArr[10 + i] = (char) ('A' + i);
		}

		StringBuilder sb = new StringBuilder("0");
		StringBuilder answer = new StringBuilder();
		
		while (answer.length() != t) {
			int tempNumber = number++;
			StringBuilder sb2 = new StringBuilder();
			while (tempNumber > 0) {
				int divideNumber = tempNumber % n;
				sb2.append(numeralSystemArr[divideNumber]);
				tempNumber /= n;
			}

			sb.append(sb2.reverse().toString());
			
			if (index < sb.length()) {
				answer.append(sb.charAt(index));
				index += m;
			}
		}

		return answer.toString();
	}

	public static void main(String[] args) {
		N진수게임 n진수게임 = new N진수게임();
		String result = n진수게임.solution(16, 16, 2, 1);
		System.out.println(result);	
	}
}