package main.Search.MinimumTimeRequired;

import java.util.Scanner;

/*
    2진 탐색으로 Goal의 값을 구하는 문제
    해당 배수의 개수는 현재 mid값을 a[i]로 나누면 배수의 개수가 몇개가 되는지 찾을 수 있고,
    그 중에서도 가장 작은 mid값을 찾는 문제다.
    친구의 도움을 받아 겨우해결함
 */

public class MinimumTimeRequired {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int g = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        long left = 0;
        long right = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left+right)/2;
            long item = 0;

            for(int i=0; i<n; i++){
                item += mid/a[i];
                if(item>= g){
                    break;
                }
            }

            if(item > g){
                right = mid-1;
                ans = mid;
            }
            else{
                left = mid+1;
            }
        }

        System.out.println(ans);


    }
}
