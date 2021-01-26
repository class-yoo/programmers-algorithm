package p20201102;

public class DP4 {
	public int solution(int[] money) {
		int[] tempArr1 = new int[money.length];
		tempArr1[0] = money[0];
		tempArr1[1] = money[1];
		tempArr1[2] = money[2] + money[0];

		int[] tempArr2 = new int[money.length];
		tempArr2[1] = money[1];
		tempArr2[2] = money[2];
		tempArr2[3] = money[3] + money[1];

		for (int i = 3; i < money.length; i++) {
			int bigNumber = Math.max(tempArr1[i - 3], tempArr1[i - 2]);
			tempArr1[i] = bigNumber + money[i];
		}

		for (int i = 4; i < money.length; i++) {
			int bigNumber = Math.max(tempArr2[i - 3], tempArr2[i - 2]);
			tempArr2[i] = bigNumber + money[i];
		}
        int bigNumber1 = Math.max(tempArr1[money.length - 3], tempArr1[money.length - 2]);
        int bigNumber2 = Math.max(tempArr1[money.length - 2], tempArr2[money.length - 1]);
		return Math.max(bigNumber1, bigNumber2);
	}

	public static void main(String[] args) {
		DP4 dp4 = new DP4();
		System.out.println(dp4.solution(new int[] { 1, 2, 3, 1 }));
		
	}
}
