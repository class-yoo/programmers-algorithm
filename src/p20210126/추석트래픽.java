package p20210126;

import java.util.Arrays;
import java.util.Comparator;

public class 추석트래픽 {
	public int solution(String[] lines) {
		int answer = 0;
		int jobStartAndEndTime[][] = new int[lines.length][2];

		for (int i = 0; i < jobStartAndEndTime.length; i++) {
			jobStartAndEndTime[i] = getStartTimeAndEndTime(lines[i]);
		}
		
		Arrays.sort(jobStartAndEndTime, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < jobStartAndEndTime.length; i++) {
			
			int monitoringStartTime = jobStartAndEndTime[i][1];
			int monitoringEndTime = monitoringStartTime + 999;
			int count = 0;
			for (int j = 0; j < jobStartAndEndTime.length; j++) {
				int targetJobStartTime = jobStartAndEndTime[j][0];
				int targetJobEndTime = jobStartAndEndTime[j][1];
				if(monitoringEndTime <= targetJobStartTime ) {
					break;
				}
				
				if(monitoringStartTime <= targetJobStartTime  
						&& targetJobStartTime < monitoringEndTime) {
					count++;
				} else if (monitoringStartTime <= targetJobEndTime
						&& targetJobEndTime < monitoringEndTime) {
					count++;
				} else if (targetJobStartTime < monitoringStartTime 
						&& monitoringEndTime < targetJobEndTime) {
					count++;
				}
				
			}
			
			answer = Math.max(answer, count);
		}
		
		return answer;
	}

	public int [] getStartTimeAndEndTime(String log) {

		String jobTime[] = log.split(" ");
		String splitTime [] = jobTime[1].split("\\.");
		String hhmmss = splitTime[0];
		String splitTime2 [] = hhmmss.split(":");
		int hh = Integer.parseInt(splitTime2[0]) * 3600 * 1000;
		int mm = Integer.parseInt(splitTime2[1]) * 60 * 1000;
		int ss = Integer.parseInt(splitTime2[2]) * 1000;
		int sss = Integer.parseInt(splitTime[1]);
		
		int processingTime = (int)(Double.parseDouble(jobTime[2].replace("s", "")) * 1000);
		
		int endTime = hh + mm + ss + sss;
		int startTime = endTime - processingTime;

		return new int [] {startTime, endTime};
	}
	
	public static void main(String[] args) {
		추석트래픽 추석트래픽 = new 추석트래픽();
		int result = 추석트래픽.solution(new String [] {
				
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.800s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.310s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.620s"
				
		});
		
		System.out.println(result);
	}
}
