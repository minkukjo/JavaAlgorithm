package main.Search.IceCreamParlor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    4
    5
    1 4 5 3 2

    이진탐색 문제인가? 했는데 생각해보니 테마가 HashTable로 되있더라.
    디스커션에도 이진탐색으로 푸는건 멍청하다고 하여 좀 더 고민해보니
    이진탐색알고리즘이 O(logn)이긴 하지만, 정렬에 최소 nlogn이 필요하기 때문에
    해쉬에 넣어서 찾는 방법이 O(n)만에 가능하다.
 */


public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            if (map.containsKey(cost[i])) {
                System.out.println(map.get(cost[i]) + " " + i + 1);
                break;
            } else {
                map.put(money - cost[i], i + 1);
            }
        }
    }
}
