package p20200831;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Heap3 {
	public int[] solution(String[] operations) {

		Deque<Integer> operationQ = new ArrayDeque<>();

		for (int i = 0; i < operations.length; i++) {

			if (operations[i].startsWith("I")) {
				operationQ.add(Integer.parseInt(operations[i].split(" ")[1]));
			} else { // 빼기 
				if (operationQ.size() > 0) {
					operationQ = getSortedDeque(operationQ);
					if ("D 1".equals(operations[i])) {
						operationQ.removeLast();
					} else {
						operationQ.removeFirst();
					}
				}
			}
		}

		operationQ = getSortedDeque(operationQ);
		
		return operationQ.size() > 0 ? 
				new int[] {operationQ.getLast(), operationQ.getFirst()} : new int[] {0, 0};
	}

	public Deque getSortedDeque(Deque<Integer> operationQ) {

		Integer[] operationArr = operationQ.toArray(new Integer[0]);
		Arrays.sort(operationArr);
		operationQ.clear();
		for (Integer number : operationArr) {
			operationQ.add(number);
		}

		return operationQ;

	}

	public static void main(String[] args) {
		Heap3 heap3 = new Heap3();

		String arr[] = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int resultArr[] = heap3.solution(arr);

		System.out.println(resultArr[0] + "   " + resultArr[1]);
	}

}
