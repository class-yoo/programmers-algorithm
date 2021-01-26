package p20200804;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash3 {
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
				continue;
			}
			map.put(clothes[i][1], 1);
		}

		for (Integer number : map.values()) {
			answer *= number + 1;
		}

		return answer-1;
	}

	public static void main(String[] args) {

		String arr[][] = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		Hash3 hash3 = new Hash3();

		int result = hash3.solution(arr);

		System.out.println(result);

	}
}
