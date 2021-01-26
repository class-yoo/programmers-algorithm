package p20201207;

import java.util.Stack;

public class 괄호변환 {
	public String solution(String p) {
		return makeCorrectParenthesis(p);
	}

	public String makeCorrectParenthesis(String p) {
		if (p.equals(""))
			return "";

		String arr[] = separateUAndV(p);
		String u = arr[0];
		String v = arr[1];

		if (isCorrectParenthesis(u) == false) {
			String temp = "";
			temp = temp.concat("(" + makeCorrectParenthesis(v) + ")");
			temp = temp.concat(reverseParenthesis(u.substring(1, u.length() - 1)));

			return temp;
		} else {
			u = u.concat(makeCorrectParenthesis(v));

			return u;
		}
	}

	public String reverseParenthesis(String p) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < p.length(); i++) {
			sb.append(p.charAt(i) == ')' ? '(' : ')');
		}

		return sb.toString();
	}

	public boolean isCorrectParenthesis(String parenthesis) {

		if (parenthesis.startsWith(")"))
			return false;
		if (parenthesis.endsWith("("))
			return false;

		Stack<Character> stack = new Stack<>();
		stack.push(parenthesis.charAt(0));
		for (int i = 1; i < parenthesis.length(); i++) {
			if (stack.peek() != parenthesis.charAt(i)) {
				stack.pop();
			} else {
				stack.push(parenthesis.charAt(i));
			}
		}

		return stack.size() > 0 ? false : true;
	}

	public String[] separateUAndV(String parenthesis) {

		String arr[] = new String[2];

		StringBuilder sb = new StringBuilder();
		int openPCount = 0;
		int closePCount = 0;
		int i = 0;

		for (; i < parenthesis.length(); i++) {
			char tempChar = parenthesis.charAt(i);
			if (tempChar == '(') {
				openPCount++;
			} else {
				closePCount++;
			}

			sb.append(tempChar);

			if (openPCount != 0 && openPCount == closePCount) {
				break;
			}
		}

		arr[0] = sb.toString();
		arr[1] = parenthesis.substring(i+1);

		return arr;
	}
	
	public static void main(String[] args) {
		괄호변환 gb = new 괄호변환();
		
		System.out.println(gb.solution("()))((()"));
	}
}
