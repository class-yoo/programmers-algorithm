package p20210528;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        Arrays.sort(scoville);

        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
            if (scoville[i] >= K) break;
        }

        while(heap.peek() < K) {
            if (heap.size() == 1) break;
            int number = heap.poll() + heap.poll() * 2;
            heap.add(number);
            answer++;
        }

        return heap.peek() < K ? -1 : answer;
    }

    public static void main(String[] args) {
        더맵게 더맵게 = new 더맵게();
        더맵게.solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
    }
}
