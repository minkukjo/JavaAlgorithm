package main.Sorting.BiggestNumber;

import java.math.BigInteger;
import java.util.ArrayList;

/*
    프로그래머스 문제
    마지막 케이스가 조금 헷갈렸다.
    0,0,0,0으로 나온 경우라면 0으로 출력해야하기때문
 */

public class BiggestNumber {
    public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> str = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            str.add(Integer.toString(numbers[i]));
        }

        str.sort((o1, o2) -> {
            if (Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1)) {
                return 1;
            } else if (Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1)) {
                return -1;
            }
            return 0;
        });

        answer = String.join("", str);

        /*
        BigInteger temp = new BigInteger(answer);

        answer = temp.toString();
        */
        if(answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,0};
        System.out.println(solution(arr));
    }
}
