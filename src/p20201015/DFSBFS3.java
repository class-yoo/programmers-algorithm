package p20201015;

public class DFSBFS3 {

	boolean[] isAleadyConverted;
	String target;
	String[] words;
	int minimumCount;

	public int solution(String begin, String target, String[] words) {

		this.isAleadyConverted = new boolean[words.length];
		this.target = target;
		this.words = words;
		this.minimumCount = Integer.MAX_VALUE;
		convertWord(begin, 0);
		return this.minimumCount == Integer.MAX_VALUE ? 0 : this.minimumCount;
	}

	public void convertWord(String begin, int count) {

		if (begin.equals(target)) {
			minimumCount = minimumCount < count ? minimumCount : count;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (isAleadyConverted[i] == true)
				continue;
			if (isConvertWordToWord(begin, words[i])) {
				isAleadyConverted[i] = true;
				convertWord(words[i], count + 1);
				isAleadyConverted[i] = false;
			}
		}
	}

	private boolean isConvertWordToWord(String word1, String word2) {

		int differCount = 0;

		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				differCount++;
			if (differCount == 2)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		DFSBFS3 dfsbfs3 = new DFSBFS3();
		System.out.println(dfsbfs3.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));

	}

}
