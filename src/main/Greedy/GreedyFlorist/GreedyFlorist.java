package main.Greedy.GreedyFlorist;

import java.util.Arrays;
import java.util.Scanner;

/*
    3 3
    2 5 6
    13

    문제와 예제가 이해가 안되서 애먹은 문제.
    친구가 꽃을 하나씩 사는데 다음 사는 꽃은 이전 산 갯수 +1 * 가격이 매겨진다.
    풀이 자체는 간단한데 문제 이해가 어려워서 애먹었다.
 */

public class GreedyFlorist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int mul = 0;
        int ans = 0;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        Arrays.sort(c);

        for (int i = n - 1; i >= 0; i--) {
            ans += (mul + 1) * c[i];
            count++;
            if (count % k == 0) {
                mul++;
            }
        }
        System.out.println(ans);


    }
}
