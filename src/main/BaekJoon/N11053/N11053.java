package main.BaekJoon.N11053;

import java.util.Arrays;
import java.util.Scanner;

public class N11053 {
    public static int lowerBound(int[] dp, int end, int n) {
        int start = 0;
        int ret = -1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (dp[m] >= n) {
                end = m - 1;
                ret = m;
            } else {
                start = m + 1;
            }
        }
        return ret;
    }

    public static int binarySearchLSI(int[] arr, int n) {
        int[] dp = new int[n + 1];
        int ans = 1;
        dp[1] = arr[1];
        int size = 1;
        for (int i = 2; i < n + 1; i++) {
            if (dp[size] < arr[i]) {
                dp[++size] = arr[i];
            } else {
                int target = lowerBound(dp, size, arr[i]);
                dp[target] = arr[i];

            }
            ans = Math.max(ans, size);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(binarySearchLSI(arr, n));

        /*
        int dp[] = new int[arr.length];

        for(int i=1; i<dp.length; i++){
            for(int j= i-1; j>=0; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max+1);
         */
    }
}
