package p20210404;


import java.util.Stack;

class 일이사나라 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int[] arr = {4, 1, 2};

        while(n > 0) {
            sb.append(arr[n % 3]);
            n = (n-1) / 3;
        }
        return sb.reverse().toString();
    }
}