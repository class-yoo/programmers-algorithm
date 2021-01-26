package p20201008;

public class DFSBFS4 {

	String[] answer;
	
	public String[] solution(String[][] tickets) {
		answer = new String[tickets.length + 1];
		for (int i = 0; i < tickets.length; i++) {
			
		}
		return answer;
	}

	public void moveCity(String[][] tickets, int firstIndex, int secondIndex) {
		
		if (isPossibleNextDestination(tickets[firstIndex][1], tickets[secondIndex][0])) {
			
		}
		
	}

	public boolean isPossibleNextDestination(String dep, String des) {
		return dep.equals(des);
	}
}
