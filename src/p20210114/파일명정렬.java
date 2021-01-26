package p20210114;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 파일명정렬 {

	public String[] solution(String[] files) {

		ArrayList<File> fileList = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			String fileName = files[i];
			
			String head = "";
			String number = "";
			String tail = "";
			int j;

			for (j = 0; j < fileName.length(); j++) {
				char temp = Character.toLowerCase(fileName.charAt(j));

				if (temp >= '0' && temp <= '9') {
					number += temp;

					if(number.length() == 5) break;
					if (fileName.charAt(j + 1) < '0' || fileName.charAt(j + 1) > '9') {
						break;
					}
				} else {
					head += temp;
				}
			}

			if (j+1 < fileName.length()) {
				tail = fileName.substring(j+1);
			}
			
			fileList.add(new File(head, number, tail, fileName));
		}
		
		Collections.sort(fileList, new File());
		
		String answer []= new String [fileList.size()];  
		
		for (int i = 0; i < fileList.size(); i++) {
			answer[i] = fileList.get(i).getFileName();
		}

		return answer;
	}

	class File implements Comparator<File> {

		private String head;
		private String number;
		private String tail;
		private String fileName;

		public File() {}
		
		public File(String head, String number, String tail, String fileName) {
			this.head = head;
			this.number = number;
			this.tail = tail;
			this.fileName = fileName;
		}

		public String getHead() {
			return head;
		}

		public String getNumber() {
			return number;
		}

		public String getTail() {
			return tail;
		}

		public String getFileName() {
			return fileName;
		}

		@Override
		public int compare(File o1, File o2) {
			int result = 0;
			int thisNumber = Integer.parseInt(o1.getNumber());
			int targetNumber = Integer.parseInt(o2.getNumber());
			
			if(o1.getHead().compareTo(o2.getHead()) > 0) {
				result = 1;
			} else if (o1.getHead().compareTo(o2.getHead()) < 0) {
				result = -1;
			} else {
				if (thisNumber > targetNumber) {
					result = 1;
				} else if(thisNumber < targetNumber) {
					result = -1;
				}
			}
			
			return result;
		}
		
	}

	public static void main(String[] args) {

		파일명정렬 파일명정렬 = new 파일명정렬();

		String result[] = 파일명정렬
				.solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
