package p20210106;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class 뉴스클러스터링 {
	public int solution(String str1, String str2) {
		int answer = 0;
		double overLapCnt = 0;

		ArrayList<String> list1 = getMakedCluster(str1);
		ArrayList<String> list2 = getMakedCluster(str2);

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i).equals(list2.get(j))) {
					overLapCnt++;
					list1.remove(i--);
					list2.remove(j);
					break;
				}
			}
		}
		
		double notOverLapCnt = list1.size() + list2.size();
		double calNumber = 
				overLapCnt + notOverLapCnt == 0 ? 1 : overLapCnt / (overLapCnt + notOverLapCnt);

		answer = (int) (calNumber * 65536);

		return answer;
	}

	public ArrayList<String> getMakedCluster(String str) {
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < str.length() - 1; i++) {
			String temp = str.substring(i, i + 2).toLowerCase();
			if (Pattern.matches("^[a-z]{2}$", temp)) 
				list.add(temp);
		}

		return list;
	}

	public static void main(String[] args) {
		뉴스클러스터링 뉴스클러스터링 = new 뉴스클러스터링();
		int result = 뉴스클러스터링.solution("aa1+aa2", "AAAA12");
		System.out.println(result);
	}
}
