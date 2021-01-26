package p20200812;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Stack3 {

	Queue<Truck> movingQ = new LinkedList<Truck>();
	Queue<Truck> watingQ = new LinkedList<Truck>();

	class Truck {

		int weight;
		int time;

		public Truck(int weight) {
			this.weight = weight;
			this.time = 1;
		}

		public void move() {
			this.time++;
		}

	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		for (int i = 0; i < truck_weights.length; i++) {
			watingQ.add(new Truck(truck_weights[i]));
		}

		int seconds = 0;
		while (!watingQ.isEmpty()) {

			if (getTotalWeight(watingQ.peek().weight) <= weight) {
				movingQ.add(watingQ.poll());
			}

			movingTruck(bridge_length);

			seconds++;

		}

		return seconds + bridge_length;
	}

	private void movingTruck(int bridge_length) {
		for (Truck truck : movingQ) {
			truck.move();
		}

		if (movingQ.peek().time > bridge_length) {
			movingQ.poll();
		}

	}

	private int getTotalWeight(int truckWeight) {
		Iterator<Truck> itr = movingQ.iterator();
		int totalWeight = 0;

		while (itr.hasNext()) {
			totalWeight += itr.next().weight;
		}

		return totalWeight += truckWeight;
	}

	public static void main(String[] args) {

		Stack3 stack3 = new Stack3();

		int result = stack3.solution(2, 10, new int[] { 7, 4, 5, 6 });

		System.out.println(result);

	}

}
