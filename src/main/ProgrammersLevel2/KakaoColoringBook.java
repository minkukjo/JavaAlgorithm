package main.ProgrammersLevel2;

public class KakaoColoringBook {

    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row;
    static int col;
    static int curMax = 1;

    public static void dfs(int x, int y, int value, int[][] picture) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && picture[nx][ny] == value) {
                curMax += 1;
                dfs(nx, ny, value, picture);
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        row = m;
        col = n;

        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture[i][j], picture);
                    maxSizeOfOneArea = Math.max(curMax, maxSizeOfOneArea);
                    curMax = 1;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public static void main(String[] args) {
        int[][] pictures = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int[] ans = solution(6, 4, pictures);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
