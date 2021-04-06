package p20210406;
import java.util.ArrayList;
import java.util.List;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        List<Integer> answers = new ArrayList<>();
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        
        int tempIdx = 0;
        while(dayOfend[tempIdx] != 0) {
            answers.add(dayOfend[tempIdx]);
            tempIdx++;
        }
        
        int[] answer = new int[answers.size()];
        int idx = 0;
        
        for(int releaseCountTemp : answers) {
            answer[idx++] = releaseCountTemp;
        }
        
        return answer;
    }

}