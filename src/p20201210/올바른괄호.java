package p20201210;

import java.util.Stack;

public class 올바른괄호 {
	
    boolean solution(String s) {
        
        if(s.startsWith(")") || s.endsWith("(")) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.push(s.charAt(i));
        		continue;
        	}
        	if (stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
        	else stack.push(s.charAt(i));
		}
        
        return stack.size() > 0 ? false : true;
    }
    
	public static void main(String[] args) {
		올바른괄호 test = new 올바른괄호();
		System.out.println(test.solution("()()"));
	}
}
