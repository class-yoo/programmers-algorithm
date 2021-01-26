package p20201103;

public class Greedy2 {
	public String solution(String number, int k) {

		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < number.length(); i++) {
			if (k == 0) {
				break;
			}
			
			if (sb.length() == 0) {
				sb.append(number.charAt(i));
				continue;
			}

			if (sb.charAt(sb.length() - 1) < number.charAt(i)) {
				sb.deleteCharAt(sb.length() - 1);
				i--;
				k--;
			} else if (sb.charAt(sb.length() - 1) == number.charAt(i)) {
				sb.append(number.charAt(i));
			} else {
				k--;
			}
		}

		return sb.toString().concat(number.substring(i+1));
	}

	public static void main(String[] args) {
		Greedy2 greedy2 = new Greedy2();
		System.out.println(greedy2.solution("4177252841", 4));

	}
}
