package main.Sorting.Hindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    a번 이상 인용된 횟수 b
    h = max(a,b)
    이 h중 가장 큰 값을 구하는 것이 h-index 문제의 해답
 */

public class Hindex {
    public static int solution(int[] citations) {
        int answer = 0;

        List<Integer> arr = Arrays.stream(citations).boxed().collect(Collectors.toList());

        arr.sort((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) <= answer) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        System.out.println(solution(arr));
    }
}
