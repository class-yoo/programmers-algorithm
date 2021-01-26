package p20201214;

public class JadenCase {
    public String solution(String s) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	char arr[] = s.toCharArray();
    	sb.append(arr[0] >= 'a' && arr[0] < 'z' ? Character.toUpperCase(arr[0]) : arr[0]); 
    	for (int i = 1; i < arr.length; i++) {
    		 char temp = arr[i-1] == ' ' ? 
    				Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
			sb.append(temp);
		}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		
    	
    	JadenCase jadenCase = new JadenCase();
    	String result = jadenCase.solution("3People unFollowed me");
//    	String result = jadenCase.solution("for the last week");
    	System.out.println(result);
    	
	}
}
