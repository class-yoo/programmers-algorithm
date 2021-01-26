package p20200807;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class Hash4 {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		HashMap<String, Integer> genreMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (genreMap.containsKey(genres[i])) {
				genreMap.replace(genres[i], genreMap.get(genres[i]) + plays[i]);
				continue;
			}
			genreMap.put(genres[i], plays[i]);
		}
		
		ArrayList<Genre> genreList = this.getSortGenre(genreMap);
		for (Genre genre : genreList) {
			String genreName = genre.getGenreName();
			
			for (int i = 0; i < answer.length; i++) {
				
			}
		}

		return answer;
	}

	public ArrayList<Genre> getSortGenre(HashMap<String, Integer> genreMap) {
		Iterator<String> itr = genreMap.keySet().iterator();
		ArrayList<Genre> genreList = new ArrayList<>();
		while (itr.hasNext()) {
			String genreName = itr.next();
			int salesVolume = genreMap.get(genreName);
			genreList.add(new Genre(genreName, salesVolume));
		}

		Genre genre = new Genre();
		Collections.sort(genreList, genre);
		
		return genreList;
	}

	class Genre implements Comparator<Genre> {
		String genreName;
		int salesVolume;

		public Genre() {
		}

		public Genre(String genreName, int salesVolume) {
			this.genreName = genreName;
			this.salesVolume = salesVolume;
		}

		@Override
		public int compare(Genre g1, Genre g2) {
			int compare = 0;

			if (g1.salesVolume < g2.salesVolume) {
				compare = 1;
			} else if (g1.salesVolume > g2.salesVolume) {
				compare = -1;
			} else {
				
			}
			return compare;

		}

		public String getGenreName() {
			return genreName;
		}

		public int getSalesVolume() {
			return salesVolume;
		}
		
		
	}

	public static void main(String[] args) {

		Hash4 hash4 = new Hash4();

		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		hash4.solution(genres, plays);
	}
}
