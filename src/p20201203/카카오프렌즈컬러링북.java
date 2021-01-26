package p20201203;

public class 카카오프렌즈컬러링북 {
	int numberOfArea;
	int maxSizeOfOneArea;
	boolean[][] isCheckedArr;
	int[][] picture;

	public int[] solution(int m, int n, int[][] picture) {
		maxSizeOfOneArea = numberOfArea = 0;
		isCheckedArr = new boolean[m][n];
		this.picture = picture;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isCheckedArr[i][j] == false && picture[i][j] != 0) {
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j, 0, picture[i][j]));
				}
			}
		}

		return new int[] { numberOfArea, maxSizeOfOneArea };
	}

	public int dfs(int i, int j, int areaSize, int initColor) {

		if (i < 0 || i >= picture.length)
			return areaSize;
		if (j < 0 || j >= picture[0].length)
			return areaSize;
		if (isCheckedArr[i][j] == true 
				|| picture[i][j] == 0
				|| initColor != picture[i][j])
			return areaSize;

		isCheckedArr[i][j] = true;
		areaSize++;

		areaSize = dfs(i, j + 1, areaSize, initColor);
		areaSize = dfs(i, j - 1, areaSize, initColor);
		areaSize = dfs(i + 1, j, areaSize, initColor);
		areaSize = dfs(i - 1, j, areaSize, initColor);

		return areaSize;
	}

	public static void main(String[] args) {

		카카오프렌즈컬러링북 coloringBook = new 카카오프렌즈컬러링북();

		int arr[] = coloringBook.solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } });

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
