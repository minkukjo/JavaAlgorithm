package main.String.MaxPalindrome;


// DP로 풀어보는 팰린드롬

public class MaxPalindrome {
    public static int solution(String s) {
        int answer = 1;
        boolean[][] dp = new boolean[2500][2500];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                answer = 2;
            }
        }


        for (int k = 3; k <= s.length(); k++) {
            for (int i = 0; i <= s.length() - k; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    answer = Math.max(answer, k);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("abcdcba");
    }
}
