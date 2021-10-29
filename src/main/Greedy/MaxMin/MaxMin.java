package main.Greedy.MaxMin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    7
    3
    10
    100
    300
    200
    1000
    20
    30

    20

    문제를 1차원적으로 접근했다가 틀린 문제.
    접근방법은 맞았다. 우선 배열을 소팅해준 뒤
    범위만큼 슬라이드 하면서 범위의 가장 작은 인덱스와 가장 큰 인덱스에 위치한 값을 뺀 값을 이전값과 계속 비교해나가면 된다.
    문제는 조합을 1개만 생각했는데, 계속 이동시키면서 해야했다.
    자바 더블 피벗 소팅이 O(nlogn)이니까 총 시간 복잡도는 O(nlogn)
 */

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i <= n - k; i++) {
            ans = Math.min(arr[k + i - 1] - arr[i], ans);
        }
        System.out.println(ans);


    }
}
