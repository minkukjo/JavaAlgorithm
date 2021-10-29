package main.Graph.Rank;

public class Rank {
    public static int solution(int n, int[][] results) {
        int answer = 0;

        int[][] graph = new int[110][110];

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1) {
                    cnt++;
                }
            }

            if (cnt == n - 1) {
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] result = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };
        solution(5, result);
    }
}
