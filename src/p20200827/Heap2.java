package p20200827;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap2 {

    public int solution(int[][] jobs) {
        int answer = 0;
        int completedJobCount = 0; // 완성된 job 개수
        int jobIndex = 0 ; // 현재 실행대기중인 마지막 job index
        int endTime = 0; // job이 끝나는시간의 합
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청시간 오름차순 정렬
        
        // 최우선 처리 Q에 넣을때, 처리시간 오름차순으로 저장되도록 구현 
        PriorityQueue<int[]> priorityQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 완성된 job의 개수가 전체 job개수 보다 작을동안 
        while (completedJobCount < jobs.length) {
        	
        	// 실행되어야할 다음job의 요청간이 이전 job 끝나는 시간보다 먼저 요청된 경우 
        	// 마지막 job이 큐에 쌓이면, jobIndex가 총 job 개수보다 커지기 때문에 선 조건 추가.
        	while(jobIndex < jobs.length && jobs[jobIndex][0] <= endTime) {
        		priorityQ.add(jobs[jobIndex++]);
        	}
        	
        	if (priorityQ.isEmpty()) { // 처리시간이 끝나기전에 들어온 job이 없는 경우
        		endTime = jobs[jobIndex][0];
        	} else {
            	// 실행할 수 있는 job 중에서 처리시간이 가장짧은 job 처리 
            	int [] processingJob = priorityQ.poll();
            	endTime += processingJob[1]; // 이전 job 끝난시간 + 방금 실행된 job 처리시간 = 최종 끝난 시간 
            	answer += endTime - processingJob[0]; // 요청된 시간부터 job이 끝나는 시간까지 더한다.
            	completedJobCount++; // 처리된 job의 개수 1증가 
        	}

        	
        }
        
        return (int) Math.floor(answer/jobs.length);
    }

	public static void main(String[] args) {
		Heap2 heap2 = new Heap2();
		
		int [][] arr = {{0, 3}, {1, 9}, {2, 6}}; 
		System.out.println(heap2.solution(arr));
	}
}
