package p20210208;


import java.util.Arrays;
import java.util.Comparator;
//실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
public class 실패율 {
    public int[] solution(int N, int[] stages) {
    	double [][] failLate = new double [N+1][2];
        int beforeStageCount = 0;
        Arrays.sort(stages);
        
        int stage = 1;
        
        for (int i = 0; i < stages.length; i++) {
			if (stage != stages[i]) {
				failLate [stage][0] = stage;
				failLate [stage][1] = (double)(i - beforeStageCount) / (double)(stages.length - beforeStageCount);
				beforeStageCount = i;
				stage++;
			}
		}
        
        Arrays.sort(failLate, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return (int)(o2[1] - o1[1]);
			}
		});
        
        int [] answer = new int [N];
        
        for (int i = 1; i < failLate.length; i++) {
        	answer[i-1] = (int)failLate[i][0];
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	실패율 실패율 = new 실패율();
    	int [] result = 실패율.solution(5, new int [] {2, 1, 2, 6, 2, 4, 3, 3});
    	for (int i = 0; i < result.length; i++) {
    		System.out.println(result[i]);
		}
	}
}
