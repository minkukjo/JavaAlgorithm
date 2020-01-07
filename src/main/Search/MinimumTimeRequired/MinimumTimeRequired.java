package main.Search.MinimumTimeRequired;

import java.util.Scanner;

public class MinimumTimeRequired {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int g = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 100000;
        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left+right)/2;
            int item = 0;

            for(int i=0; i<n; i++){
                item += mid/a[i];
            }

            if(item > g){
                right = mid-1;
            }
            else if(item == g){
                right -=1;
                ans = Math.min(ans,mid);
            }
            else{
                left = mid+1;
            }
        }

        System.out.println(ans);


    }
}
