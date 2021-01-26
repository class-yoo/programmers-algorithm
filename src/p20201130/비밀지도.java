package p20201130;

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
			
			int remain = n - binaryString.length();
			
			for (int j = 0; j < remain; j++) {
				binaryString = "0" + binaryString; 
			}
			
			answer[i] = binaryString.replace("1", "#").replace("0", " ");
		}
		
		return answer;
	}

	public static void main(String[] args) {

		비밀지도 secretMap = new 비밀지도();

		String[] answer = secretMap.solution(6, 
				new int[] { 46, 33, 33, 22, 31, 50 },
				new int[] { 27, 56, 19, 14, 14, 10 });

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
}