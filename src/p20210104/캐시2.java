package p20210104;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 캐시2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> cache = new HashSet<>();

        if(cacheSize == 0) return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();

            if (queue.isEmpty()) {
                queue.add(cities[i]);
                cache.add(cities[i]);
                answer += 5;
                continue;
            }

            if (cache.contains(cities[i])) {
                answer++;
                queue.remove(cities[i]);
                queue.add(cities[i]);
            } else {
                queue.add(cities[i]);
                cache.add(cities[i]);
                answer += 5;
                if (cache.size() > cacheSize) {
                    String city = queue.remove();
                    cache.remove(city);
                }
            }
        }

        return answer;
    }

}