package main.ProgrammersLevel2;

public class BiggestSquare {
    public static int solution(int[][] board) {
        int answer = board[0][0];

        int[][] dp = new int[1001][1001];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1 && board[i - 1][j] == 1 && board[i][j - 1] == 1 && board[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        int solution = solution(board);
        System.out.println(solution);

    }
}