package p20210404;

import java.util.Arrays;

class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min=1;
        long max = (long)times[times.length-1]*n; // 최대 오래 걸리는 시간 = 10억 * 10억 > 10억분 걸리는 검사관한테 10억명이 몰릴 경우
        long sum;
        long answer = max;

        while(min<=max){ // 이분탐색을 모두 끝낸경우 min = 100 , mid 101 , max 102인 경우가 될때 까지 실행
            sum=0;
            long mid = (min+max)/2; // min = 1, max= 600 > 300이됨
            for(int time:times){
                // 심사관 하나당 맡을수 있는 입국자수
                // 만약 300분인 경우를 확인하려 경우에 times가 1, 2, 3, 5인 경우.
                // 각 심사위원들이 맡을 수 있는 입국자수는 300, 150, 100, 60 명이다. 그러면 총 300 + 150 + 100 + 60 = 610 명
                // 만약 150분인 경우를 확인하는 경우, 150, 75, 50, 30 = 305명
                sum+=mid/time;
            }

            // 총 맡을 수 있는 수에 비해 입국심사자 수가 적거나 같으면 총 610명을 맡을 수 있는데 입국자수가 300명이면 시간을 줄여서 재확인
            // 1 ~ 299 재탐색
            // 만약 150분인 경우 입국심사자 수가 적거나 같으면 총 305명을 맡을 수 있는데 입국자수가 300명이면 시간을 줄여서 재확인

            if(sum>=n) {
                answer = mid < answer ? mid : answer;
                max = mid-1;
            }

            // 총 맡을 수 있는 수 < 입국심사자 수인 경우, 총 610명을 맡을 수 있는데 입국자수가 1000명이면 시간을 늘려서 재확인
            // 301 ~ 600 재탐색
            else {
                min = mid+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        입국심사 입국심사 = new 입국심사();
        long result = 입국심사.solution(6, new int[]{7, 10});
        System.out.println(result);
    }
}
