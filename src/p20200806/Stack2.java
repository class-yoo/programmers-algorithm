package p20200806;

import java.util.ArrayList;

public class Stack2 {

	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> returnList = new ArrayList<>();
		int releaseIndex = 0;

		while (releaseIndex != -1) {
			for (int i = 0; i < progresses.length; i++) {
				progresses[i] += speeds[i];
			}

			if (progresses[releaseIndex] >= 100) {
				int releaseCount = 0;
				int unreleaseIndex = -1;
				for (int i = releaseIndex; i < progresses.length; i++) {
					if (progresses[i] >= 100) {
						releaseCount++;
					} else {
						unreleaseIndex = unreleaseIndex == -1 ? i : unreleaseIndex;
					}
				}
				releaseIndex = unreleaseIndex;
				returnList.add(releaseCount);
			}

		}

		return convertListToArray(returnList);
	}

	public int[] convertListToArray(ArrayList<Integer> returnList) {

		int[] releaseArray = new int[returnList.size()];

		for (int i = 0; i < releaseArray.length; i++) {
			releaseArray[i] = returnList.get(i);
		}
		return releaseArray;
	}

	public static void main(String[] args) {

		int progresses[] = { 94, 60, 60 };
		int speeds[] = { 1, 30, 5 };

		Stack2 stack2 = new Stack2();		int[] result = stack2.solution(progresses, speeds);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
