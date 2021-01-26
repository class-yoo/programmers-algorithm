package p20210104;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 캐시 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> cache = new HashSet<>();
		
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toLowerCase();
			
			if (!cache.contains(cities[i])) {
				queue.add(cities[i]);
				cache.add(cities[i]);
				answer += 5;
				if (cache.size() > cacheSize) {
					String city = queue.poll();
					cache.remove(city);
				}
			} else {
				queue.remove(cities[i]);
				queue.add(cities[i]);
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {

		캐시 캐시 = new 캐시();

		int result = 캐시.solution(3, 
				new String[] { 
						"A", "A", 
						"B", 
						"C", 
						"D", 
						"E", 
						"F", 
						"G", "G"});

		System.out.println(result);
	}
}
