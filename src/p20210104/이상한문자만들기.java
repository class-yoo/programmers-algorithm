package p20210104;

public class 이상한문자만들기 {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isUppperCase = true;

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (isUppperCase) {
				temp = Character.toUpperCase(temp);
				isUppperCase = false;
			} else {
				temp = Character.toLowerCase(temp);
				isUppperCase = true;					
			}
			sb.append(temp);
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		이상한문자만들기 이상한문자만들기 = new 이상한문자만들기();
		String result = 이상한문자만들기.solution("try hello world");
		
		System.out.println(result);
	}
}
