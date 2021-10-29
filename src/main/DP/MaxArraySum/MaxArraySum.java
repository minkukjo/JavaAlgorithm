package main.DP.MaxArraySum;

import java.util.Scanner;

/*
    인접하지않은 배열 쌍의 값을 구하는 문제
    O(N^2)으로 푸니까 시간초과남...

 */

public class MaxArraySum {
    static int MyLogic(int[] DP, int max, int[] arr) {
        DP[0] = arr[0];
        DP[1] = arr[1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j - i > 1) {
                    DP[j] = Math.max(DP[i] + arr[j], DP[j]);
                    max = Math.max(DP[j], max);
                }
            }
        }
        return max;
    }

    public static int answer(int[] arr) {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(arr[0], 0);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[1], arr[0]);
        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(answer(arr));

    }
}
