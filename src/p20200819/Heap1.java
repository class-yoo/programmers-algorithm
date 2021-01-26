package p20200819;

import java.util.ArrayList;

public class Heap1 {

	class MinHeap {
		private ArrayList<Integer> heap;

		public MinHeap() {
			heap = new ArrayList<>();
			heap.add(0);
		}

		public int getRootNumber() {
			return heap.get(1);
		}

		public int getSecondNumber() {
			if (heap.size() == 2) {
				return -1;
			} else if (heap.size() == 3) {
				return heap.get(2);
			}

			return heap.get(2) > heap.get(3) ? heap.get(2) : heap.get(3);
		}

		public void insert(int value) {
			heap.add(value);
			int p = heap.size() - 1;

			while (p > 1 && heap.get(p / 2) > heap.get(p)) {
				int tmp = heap.get(p / 2);
				heap.set(p / 2, heap.get(p));
				heap.set(p, tmp);
			}

			p = p / 2;
		}

		public int delete() {
			if (heap.size() - 1 < 1) {
				return -1;
			}

			int deleteItem = heap.get(1);

			heap.set(1, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);

			int pos = 1;
			while ((pos * 2) < heap.size()) {

				int min = heap.get(pos * 2);
				int minPos = pos * 2;

				if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
					min = heap.get(pos * 2 + 1);
					minPos = pos * 2 + 1;
				}

				if (heap.get(pos) < min)
					break;

				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);
				pos = minPos;
			}

			return deleteItem;
		}

	}

	public int solution(int[] scoville, int K) {
		int answer = 0;

		MinHeap heap = new MinHeap();

		for (int i = 0; i < scoville.length; i++) {
			heap.insert(scoville[i]);
		}

		while (heap.getRootNumber() < K) {
			int heapRootNumber = heap.getRootNumber();
			int heapSecondNumber = heap.getSecondNumber();

			if (heapSecondNumber == -1) {
				return -1;
			}

			for (int i = 0; i < 2; i++) {
				heap.delete();
			}

			heap.insert(heapRootNumber + (heapSecondNumber * 2));
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		Heap1 heap1 = new Heap1();

		System.out.println(heap1.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}
}
