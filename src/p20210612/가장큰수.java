package p20210612;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {
    public String solution(int[] numbers) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]+"");
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String answer = String.join("", list);

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
