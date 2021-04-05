package p20210404;

public class 입국심사2 {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        int maxTime = 0;

        for(int i=0; i<times.length; i ++) {
            maxTime = Math.max(maxTime, times[i]);
        }

        long min = 1;
        long max = (long)maxTime * n;

        while (min <= max) {

            long totalCount = 0;
            long mid = (min + max) / 2;

            for(int i=0; i< times.length; i++) {
                totalCount += mid/times[i];
            }

            if(totalCount >= n) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            } else if(totalCount < n) {
                min = mid + 1;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        입국심사2 입국심사 = new 입국심사2();
        long result = 입국심사.solution(6, new int[]{7, 10});
        System.out.println(result);
    }
}