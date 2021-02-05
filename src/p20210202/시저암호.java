package p20210202;

public class 시저암호 {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);

			if (temp != ' ') {	
				char convertChar = (char) ((int) temp + n);
				if (temp >= 'a' && temp <= 'z') {
					if (convertChar > 'z') {
						convertChar = (char) ('a' + ((int)convertChar % 'z')-1);
					}
				} else {
					if (convertChar > 'Z') {
						convertChar = (char) ('A' + ((int)convertChar % 'Z')-1);
					}
				}
				sb.append(convertChar);
			} else {
				sb.append(' ');
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		시저암호 시저암호 = new 시저암호();
		String result = 시저암호.solution("z", 1);
		System.out.println(result);
	}
}
