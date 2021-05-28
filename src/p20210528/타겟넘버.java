package p20210528;

public class 타겟넘버 {
    int[] numbers;
    int cnt;
    int target;

    public int solution(int[] numbers, int target) {
        setCorrectCalNumCnt(numbers, target);
        return cnt;
    }

    public void setCorrectCalNumCnt(int[] numbers, int target) {
        this.cnt = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(-1, 0);
    }

    public void dfs(int idx, int calNum) {
        if (idx+1 >= numbers.length -1) {
            if (target == calNum) {
                cnt++;
            }
            return;
        }

        dfs(idx+1, calNum + numbers[idx+1]);
        dfs(idx+1, calNum - numbers[idx+1]);
    }

    public static void main(String[] args) {
        타겟넘버 타겟넘버 = new 타겟넘버();
        타겟넘버.solution(new int[] {1, 1, 1, 1, 1}, 3);
    }
}
