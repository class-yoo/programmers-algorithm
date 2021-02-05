package p20210202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 순위검색 {

	public static final int JAVA = 1;
	public static final int PYTHON = 2;
	public static final int CPP = 3;

	public static final int BACK_END = 1;
	public static final int FRONT_END = 2;

	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;

	public static final int PIZZA = 1;
	public static final int CHICKEN = 2;

	public static final int EMPTY = -1;

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		ArrayList<Applyer> list = new ArrayList<>();

		for (int i = 0; i < info.length; i++) {
			String[] infoArr = info[i].split(" ");

			int lang = getLanguageInt(infoArr[0]);
			int job = getJobInt(infoArr[1]);
			int level = getLevelInt(infoArr[2]);
			int food = getFoodInt(infoArr[3]);
			int score = Integer.parseInt(infoArr[4]);

			list.add(new Applyer(lang, job, level, food, score));
		}

		Collections.sort(list, new Applyer());

		for (int i = 0; i < query.length; i++) {
			String[] infoArr = query[i].split(" and ");
			int lang = getLanguageInt(infoArr[0]);
			int job = getJobInt(infoArr[1]);
			int level = getLevelInt(infoArr[2]);
			String foodAndScore [] = infoArr[3].split(" ");
			int food = getFoodInt(foodAndScore[0]); 
			int score = Integer.parseInt(foodAndScore[1]);

			int index = getDivisionIndex(list, score);
			int cnt = 0;

			for (int j = index; j < list.size(); j++) {
				if (lang != EMPTY)
					if (list.get(j).lang != lang)
						continue;

				if (job != EMPTY)
					if (list.get(j).job != job)
						continue;

				if (level != EMPTY)
					if (list.get(j).level != level)
						continue;

				if (food != EMPTY)
					if (list.get(j).food != food)
						continue;
				
				cnt++;
			}
			answer[i] = cnt;
		}
		
		return answer;
	}

	private int getDivisionIndex(ArrayList<Applyer> list, int compareScore) {

		int left = 0;
		int right = list.size() - 1;
		int middle = (left + right) / 2;

		while (left < right) {

			if (compareScore <= list.get(middle).score) {
				right = middle;
			} else {
				left = middle + 1;
			}

			middle = (left + right) / 2;

		}
		
		return middle;
	}

	private int getLanguageInt(String lang) {
		if (lang.equals("java"))
			return JAVA;
		else if (lang.equals("python"))
			return PYTHON;
		else if (lang.equals("cpp"))
			return CPP;

		return EMPTY;
	}

	private int getJobInt(String job) {
		if (job.equals("backend"))
			return BACK_END;
		else if (job.equals("frontend"))
			return FRONT_END;
		return EMPTY;
	}

	private int getLevelInt(String level) {
		if (level.equals("senior"))
			return SENIOR;
		else if (level.equals("junior"))
			return JUNIOR;
		return EMPTY;
	}

	private int getFoodInt(String food) {
		if (food.equals("pizza"))
			return PIZZA;
		if (food.equals("chicken"))
			return CHICKEN;
		return EMPTY;
	}

	public static void main(String[] args) {
		순위검색 순위검색 = new 순위검색();
		String arr[] = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };

		String arr2[] = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100","- and - and - and - 150"};

		int result[] = 순위검색.solution(arr, arr2);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}

class Applyer implements Comparator<Applyer> {
	int lang;
	int job;
	int level;
	int food;
	int score;

	public Applyer() {
	}

	public Applyer(int lang, int job, int level, int food, int score) {
		this.lang = lang;
		this.job = job;
		this.level = level;
		this.food = food;
		this.score = score;
	}

	@Override
	public int compare(Applyer o1, Applyer o2) {
		return o1.score - o2.score;
	}

}