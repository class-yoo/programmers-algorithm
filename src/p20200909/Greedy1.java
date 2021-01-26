package p20200909;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Greedy1 {

	public int solution(int n, int[] lost, int[] reserve) {

		Set<Integer> lostSet = new HashSet<>();
		Set<Integer> lostSet2 = new HashSet<>();
		Set<Integer> reserveSet = new HashSet<>();

		for (int i = 0; i < lost.length; i++) {
			lostSet.add(lost[i]);
			lostSet2.add(lost[i]);
		}

		for (int i = 0; i < reserve.length; i++) {
			reserveSet.add(reserve[i]);
		}

		Iterator<Integer> itr1 = lostSet.iterator();

		while (itr1.hasNext()) {
			int number = itr1.next();

			if (reserveSet.contains(number - 1)) {
				lostSet2.remove(number);
				reserveSet.remove(number - 1);
			} else if (reserveSet.contains(number + 1)) {
				lostSet2.remove(number);
				reserveSet.remove(number + 1);
			}
		}

		return n - lostSet2.size();
	}

	public static void main(String[] args) {
		Greedy1 greedy1 = new Greedy1();
		System.out.println(greedy1.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));

	}

}
