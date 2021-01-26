package p20210113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 압축 {
	public int[] solution(String msg) {
		ArrayList<Integer> list = new ArrayList<>();
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		Set<Integer> alreadyPrintSet = new HashSet<>();

		int index = 1;
		for (char i = 'A'; i <= 'Z'; i++) {
			dictionary.put(String.valueOf(i), index++);
		}

		for (int i = 0; i < msg.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(msg.charAt(i));

			for (int j = i + 1; j < msg.length(); j++) {
				String w = sb.toString();

				if (dictionary.containsKey(w)) {
					if (!alreadyPrintSet.contains(dictionary.get(w))) {
						alreadyPrintSet.add(dictionary.get(w));
						list.add(dictionary.get(w));
					}

					sb.append(msg.charAt(j));
				} else {
					dictionary.put(w, index++);
					break;
				}
			}
		}

		int answer[] = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {

		압축 압축 = new 압축();
		int result[] = 압축.solution("KAKAO");

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
