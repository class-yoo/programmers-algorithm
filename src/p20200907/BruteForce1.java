package p20200907;

import java.util.HashSet;
import java.util.Set;

public class BruteForce1 {

	Set<String> set = new HashSet<>();

	public int solution(String numbers) {

		String[] numberArr = numbers.split("");

		for (int i = 0; i < numberArr.length; i++) {
			if (!numberArr[i].equals("0")) {
				setPrimeNumberToArrayList(i + 1, numberArr[i], numberArr);
			}
		}

		return set.size();
	}

	public void setPrimeNumberToArrayList(int k, String prefix, String[] numberArr) {

		if (k == 0)
			return;

		if (isPrimeNumber(Integer.valueOf(prefix))) {
			set.add(prefix);
		}

		for (int i = 0; i < numberArr.length; i++) {
			setPrimeNumberToArrayList(k - 1, prefix + numberArr[i], numberArr);
		}
	}

	public boolean isPrimeNumber(int num) {

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return num == 1 ? false : true;
	}

	public static void main(String[] args) {
		System.out.println(new BruteForce1().solution("17"));
	}
}
