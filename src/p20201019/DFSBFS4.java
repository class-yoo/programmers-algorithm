package p20201019;

import java.util.ArrayList;
import java.util.Collections;

public class DFSBFS4 {

	ArrayList<String> countries;
	String[][] tickets;
	boolean[] isVisited;

	public String[] solution(String[][] tickets) {
		countries = new ArrayList<>();
		isVisited = new boolean[tickets.length];
		this.tickets = tickets;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				isVisited[i] = true;
				move(tickets[i][0], 0, i);
				isVisited[i] = false;
			}
		}

		Collections.sort(countries);
		System.out.println(countries.get(0));
		String answers[] = countries.get(0).split(",");
		return answers;
	}

	public void move(String route, int moveCount, int index) {

		if (moveCount == this.tickets.length - 1) {
			countries.add(route.concat("," + this.tickets[index][1]));
			return;
		}

		isVisited[index] = true;

		for (int i = 0; i < this.tickets.length; i++) {
			if (index == i)
				continue;
			if (isVisited[i] == true)
				continue;
			if (this.tickets[index][1].equals(this.tickets[i][0])) {
				move(route.concat("," + this.tickets[i][0]), moveCount + 1, i);
			}
		}

		isVisited[index] = false;
	}

	public static void main(String[] args) {
		DFSBFS4 dfsbfs4 = new DFSBFS4();

		dfsbfs4.solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });

	}
}
