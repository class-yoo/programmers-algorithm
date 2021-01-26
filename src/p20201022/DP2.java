package p20201022;

public class DP2 {

	public int solution(int[][] triangle) {

		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int k = 0; k < triangle[i].length; k++) {

				int targetFloorMax = triangle[i + 1][k] > triangle[i + 1][k + 1] ? 
						triangle[i + 1][k] : triangle[i + 1][k + 1];
				triangle[i][k] = triangle[i][k] + targetFloorMax;
			}
		}

		return triangle[0][0];
	}

	
	
	
	
	
	public static void main(String[] args) {
//		DP2 dp2 = new DP2();
//		dp2.solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } });
		
		int i = 1;
		
		int a = ++i + ++i;
		System.out.println(a);
		
	}
}
