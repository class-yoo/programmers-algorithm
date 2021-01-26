package p20201210;


public class 올바른괄호2 {
	
    boolean solution(String s) {
        
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') left++;
        	else left--;
		}
        
    	if (left != 0) return false;
        
        return true;
    }
    
	public static void main(String[] args) {
		올바른괄호2 test = new 올바른괄호2();
		System.out.println(test.solution("()()"));
	}
}
