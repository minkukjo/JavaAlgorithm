package main.ProgrammersLevel2;

import java.math.BigInteger;

public class NormalSquare {
    public static long solution(int w, int h) {
        long answer = 1;

        BigInteger wb = BigInteger.valueOf(w);
        BigInteger hb = BigInteger.valueOf(h);

        long cut = w + h - wb.gcd(hb).intValue();
        answer = (long) w * h - cut;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
}
