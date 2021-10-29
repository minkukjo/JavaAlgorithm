package main.ProgrammersLevel2;

public class MakeBigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
    }

    private static String solution(String number, int k) {
        StringBuilder ans = new StringBuilder(number);


        int delete = 0;
        int i = 1;
        while (delete != k) {

            if (i >= 1 && ans.charAt(i - 1) < ans.charAt(i)) {
                ans.deleteCharAt(i - 1);
                delete++;
                i--;
            } else if (i == ans.length() - 1 && ans.charAt(i) <= ans.charAt(i - 1)) {
                ans.deleteCharAt(i);
                delete++;
                i--;
            } else {
                i++;
            }
        }

        return ans.toString();
    }
}
