package p20201007;

public class DFSBFS3 {
	
    public int solution(String begin, String target, String[] words) {
        return convertWord(begin, target, words, 0, 0);
    }
    
    public int convertWord(String begin, String target, String[] words, int count, int index) {
        
        if (index == words.length) return 0;
        if (begin.equals(target)) {
        	return count;
        }
        int checkResult = Integer.MAX_VALUE;
        int tempResult = 0;
        
        for(int i=0; i < words.length; i++) {
        	if ("".equals(words[i])) continue;
            if (isDifferentOnlyOneSpell(begin, words[i])) {
            	String tempWord = words[i];
            	words[i] = "";
                tempResult = convertWord(tempWord, target, words, count +1, index+1);
                words[i] = tempWord;
                if (tempResult > 0) {
                	checkResult = checkResult < tempResult ? checkResult : tempResult;
				}
            }
        }
        
        return checkResult < Integer.MAX_VALUE ? checkResult : 0;
    }
    
    public boolean isDifferentOnlyOneSpell(String s1, String s2) {
        int differCount = 0;
        for(int i=0; i < s1.length(); i++) {
            
            if (s1.charAt(i) != s2.charAt(i)) {
                if(++differCount > 1) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	DFSBFS3 dfsbfs3 = new DFSBFS3();
    	
    	System.out.println(dfsbfs3.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
    
}
