package p20210128;

public class 신규아이디추천 {
	public String solution(String new_id) {

		new_id = convertBigToSmall(new_id);
		new_id = removeChar(new_id);
		new_id = convertDot(new_id);
		new_id = removeFirstDotAndFinalDot(new_id);
		new_id = IfEmptyStringSetA(new_id);
		new_id = clearLength(new_id);
		new_id = addLastChar(new_id);
		new_id = removeFirstDotAndFinalDot(new_id);
		
		return new_id;
	}

	public String convertBigToSmall(String id) {
		return id.toLowerCase();
	}

	public String removeChar(String id) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < id.length(); i++) {
			char tempChar = id.charAt(i);

			if ((tempChar >= 'a' && tempChar <= 'z')) {
				sb.append(tempChar);
				continue;
			}

			if ((tempChar >= '0' && tempChar <= '9')) {
				sb.append(tempChar);
				continue;
			}

			if (tempChar == '-' || tempChar == '_' || tempChar == '.') {
				sb.append(tempChar);
				continue;
			}
		}

		return sb.toString();
	}

	public String convertDot(String id) {
		while (id.contains("..")) {
			id = id.replace("..", ".");
		}
		return id;
	}

	public String removeFirstDotAndFinalDot(String id) {

		if (id.startsWith(".")) {
			id = id.substring(1);
		}

		if (id.endsWith(".")) {
			id = id.substring(0, id.length() - 1);
		}

		return id;
	}

	public String IfEmptyStringSetA(String id) {
		if (id.equals("")) {
			return "a";
		}
		
		return id;
	}
	
	public String clearLength(String id) {
		if(id.length() > 15) {
			id = id.substring(0, 15);
		}
		
		return id;
	}

	
	public String addLastChar(String id) {
		while (id.length() < 3) {
			id += id.charAt(id.length()-1);
		}
		return id;
	}
	
	public static void main(String[] args) {
		신규아이디추천 신규아이디추천 = new 신규아이디추천();
		String result = 신규아이디추천.solution("...!@BaT#*..y.abcdefghijklm");
		
		System.out.println(result);
	}
}
