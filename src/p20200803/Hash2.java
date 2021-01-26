package p20200803;

public class Hash2 {
	class Solution {
	    public boolean solution(String[] phone_book) {
	        
	        for(int i=0; i<phone_book.length; i++) {
	            for(int j=0; j<phone_book.length; j++) {
	                if(j != i && phone_book[j].startsWith(phone_book[i])) return false;
	            }
	        }
	        
	        return true;
	    }
	}
    
    public static void main(String[] args) {
		Hash2 hash2 = new Hash2();
		
	}
}
