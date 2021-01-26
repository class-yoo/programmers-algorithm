package p20200805;

public class Stack1 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int j = i + 1;
//	            int downCheckNumber = 1; // 떨어지지 않은경우 반복문 탈출시 1이 더 증가하기 때문에 빼줘야함
			for (; j < prices.length; j++) {
				if (prices[i] > prices[j]) {
//	                	downCheckNumber = 0; // 떨어진경우가 체크되면 반복문 탈출되기에 0을 빼줘야함
					j++;
					break;
				}
			}
			answer[i] = j - i - 1;

		}
		return answer;
	}

	public int[] solution2(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int j = i + 1;
			for (; j < prices.length; j++) {
				if (prices[i] > prices[j]) {
					j++;
					break;
				}
			}
			answer[i] = j - i - 1;

		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
