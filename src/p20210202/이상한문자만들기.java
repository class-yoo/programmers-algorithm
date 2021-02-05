package p20210202;

public class 이상한문자만들기 {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isUppperCase = true;

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (Character.isAlphabetic(temp)) {
				temp = isUppperCase ? Character.toUpperCase(temp) : Character.toLowerCase(temp);
				isUppperCase = !isUppperCase;
			} else {
				isUppperCase = true;
			}
			
			sb.append(temp);
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		이상한문자만들기 이상한문자만들기 = new 이상한문자만들기();
		System.out.println(이상한문자만들기.solution("try hello world"));
	}
}
