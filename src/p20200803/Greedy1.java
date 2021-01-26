package p20200803;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Greedy1 {

	public int solution(int n, int[] lost, int[] reserve) {

		Set<Integer> lostSet = new HashSet<>();
		Set<Integer> reserveSet = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);
		
		for (int i = 0; i < lost.length; i++) {
			lostSet.add(lost[i]);
		}

		for (int i = 0; i < reserve.length; i++) {
			reserveSet.add(reserve[i]);
		}

		
		for (int i = 0; i < lost.length; i++) {
			if (lostSet.contains(lost[i]) && reserveSet.contains(lost[i])) {
				lostSet.remove(lost[i]);
				reserveSet.remove(lost[i]);
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (reserveSet.contains(lost[i] - 1)) {
				lostSet.remove(lost[i]);
				reserveSet.remove(lost[i] - 1);
			} else if (reserveSet.contains(lost[i] + 1)) {
				lostSet.remove(lost[i]);
				reserveSet.remove(lost[i] + 1);
			}
		}

		return n - lostSet.size();
	}

	public static void main(String[] args) {
		Greedy1 greedy1 = new Greedy1();
		System.out.println(greedy1.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));

	}

}
