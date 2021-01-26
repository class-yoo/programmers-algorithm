package p20200902;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting1 {

	public String solution(int[] numbers) {

		String[] stringNumbers = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			stringNumbers[i] = String.valueOf(numbers[i]);
		}

		stringNumbers = sortNumber(stringNumbers);

		return stringNumbers[0].equals("0") ? stringNumbers[0] : String.join("", stringNumbers);
	}

	public String[] sortNumber(String[] stringNumbers) {
		
		Arrays.sort(stringNumbers, new Comparator<String>() {

			@Override
			public int compare(String o2, String o1) {
				return (o2 + o1).compareTo(o1 + o2);
			}

		});

		return stringNumbers;
	}
}
