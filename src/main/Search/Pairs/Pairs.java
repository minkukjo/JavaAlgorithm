package main.Search.Pairs;


import java.util.HashMap;
import java.util.Scanner;

/*
    Medium 치곤 상당히 쉬운문제였다.
    유니크한 배열이 주어질때 특정값 K가 있다고 하자.
    배열안에 두 값의 차이가 K가 되는 쌍의 개수를 구하는 문제였다.
    해쉬맵으로 간단히 해결!
 */

public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            hashMap.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(arr[i] - k)) {
                ans++;
            }
        }

        System.out.println(ans);

    }
}
