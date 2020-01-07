package main.Search.TripleSum;

import java.util.Arrays;
import java.util.Scanner;

/*
    처음에 중복 제거 로직을 빼먹어서 틀린 문제
    디스커션을 보니 stream을 이용해서 깔끔하게 배열의 중복제거와 소팅까지 한 예제가 있어 가져와 보았다.
    이제야 자바8을 제대로 사용하고 있는 듯한 느낌이다.
 */

public class TripleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();

        int ans = 0;
        int[] a = new int[p];
        int[] b = new int[q];
        int[] c = new int[r];

        for(int i=0; i<p; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<q; i++){
            b[i] = sc.nextInt();
        }
        for(int i=0; i<r; i++){
            c[i] = sc.nextInt();
        }

        int[] arr = Arrays.stream(a).sorted().distinct().toArray();
        int[] brr = Arrays.stream(b).sorted().distinct().toArray();
        int[] crr = Arrays.stream(c).sorted().distinct().toArray();

        for(int i=0; i<brr.length; i++){
            long first = Arrays.binarySearch(arr,brr[i]);
            long second = Arrays.binarySearch(crr,brr[i]);
            if( first == -1 || second == -1) continue;

            if(first < -1 && Math.abs(first)-1 >= arr.length ){
                first = arr.length;
            }else if(first < -1){
                first = Math.abs(first) -1;
            }else {
                first = first+1;
            }
            if(second < -1 && Math.abs(second)-1 >= crr.length ){
                second = crr.length;
            }else if(second < -1){
                second = Math.abs(second)-1;
            }else {
                second = second+1;
            }

            ans += first*second;
        }

        System.out.println(ans);

    }
}
