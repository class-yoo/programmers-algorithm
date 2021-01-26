package p20200803;

public class Hash2_notwork {
    public boolean solution(String[] phone_book) {
        
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=1; j<phone_book.length; j++) {
                if(j != i && phone_book[j].startsWith(phone_book[i])) return false;
            }   
        }
        
        return true;
    }
}
