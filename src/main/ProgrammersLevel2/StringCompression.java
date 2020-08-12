package main.ProgrammersLevel2;

public class StringCompression {
    public static int solution(String s) {

        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            StringBuilder result = new StringBuilder();
            String prev = s.substring(0, i);
            int hit = 1;

            for (int j = i; j < s.length(); j += i) {
                int len = Math.min(j + i, s.length());
                String substring = s.substring(j, len);
                if (prev.equals(substring)) {
                    hit++;
                } else {
                    if (hit == 1) {
                        result.append(prev);
                    } else {
                        result.append(hit).append(prev);
                    }
                    prev = substring;
                    hit = 1;
                }
            }

            if (hit != 1) {
                result.append(hit).append(prev);
            } else {
                result.append(prev);
            }

            answer = Math.min(result.length(), answer);

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }
}
