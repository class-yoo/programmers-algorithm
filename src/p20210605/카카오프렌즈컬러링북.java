package p20210605;

public class 카카오프렌즈컬러링북 {

    int[][] picture;
    boolean[][] isVisited;
    int height;
    int width;
    int numberOfArea;
    int maxSizeOfOneArea;
    int curSizeOfOneArea;

    public int[] solution(int m, int n, int[][] picture) {
        this.numberOfArea = 0;
        this.maxSizeOfOneArea = 0;
        this.picture = picture;
        this.isVisited = new boolean[m][n];
        this.height = m;
        this.width = n;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j] == false && picture[i][j] != 0) {
                    numberOfArea++;
                    this.curSizeOfOneArea = 0;
                    dfs(picture[i][j], i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, curSizeOfOneArea);
                }
            }
        }

        return new int[] {this.numberOfArea, this.maxSizeOfOneArea};
    }

    public void dfs(int curColor, int i, int j) {

        if (i < 0 || j < 0 || i >= height || j >= width)
            return;

        if (isVisited[i][j])
            return;

        if (picture[i][j] == 0)
            return;

        if (picture[i][j] != curColor)
            return;

        isVisited[i][j] = true;
        curSizeOfOneArea++;

        dfs(curColor, i - 1, j);
        dfs(curColor, i + 1, j);
        dfs(curColor, i, j - 1);
        dfs(curColor, i, j + 1);

    }

    public static void main(String[] args) {
        카카오프렌즈컬러링북 카카오프렌즈컬러링북 = new 카카오프렌즈컬러링북();
        int[] result = 카카오프렌즈컬러링북.solution(6, 4 ,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
