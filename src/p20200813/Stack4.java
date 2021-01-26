package p20200813;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Stack4 {

	class Docs {

		int index;
		int sequence;

		public Docs(int index, int sequence) {
			this.index = index;
			this.sequence = sequence;
		}
	}

	public int solution(int[] priorities, int location) {

		int answer = 0;
		int requestedDocsIndex = location;

		Queue<Docs> priorityQ = new LinkedList<Docs>();

		setWillPrintDocs(priorityQ, priorities);
		
		while (true) {	
			Docs printingDocs = priorityQ.poll();

			if (isContainPriority(priorityQ, printingDocs.sequence)) {
				priorityQ.add(printingDocs);
			} else {
				answer++;
				if (printingDocs.index == requestedDocsIndex) {
					break;
				}
			}
		}

		return answer;
	}

	private void setWillPrintDocs(Queue<Docs> priorityQ, int[] priorities) {
		for (int i = 0; i < priorities.length; i++) {
			priorityQ.add(new Docs(i, priorities[i]));
		}
	}

	private boolean isContainPriority(Queue<Docs> priorityQ, int printingDocsIndex) {

		Iterator<Docs> itr = priorityQ.iterator();

		while (itr.hasNext()) {
			if (itr.next().sequence > printingDocsIndex) {
				return true;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		
		Stack4 stack4 = new Stack4();
		
		stack4.solution(new int []{2, 1, 3, 2}, 2);
		
	}
}
