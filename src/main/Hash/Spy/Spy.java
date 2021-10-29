package main.Hash.Spy;

import java.util.HashMap;

public class Spy {

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) {
                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            } else {
                hashMap.put(clothes[i][1], 1);
            }
        }

        for (int v : hashMap.values()) {
            answer *= (v + 1);
        }
        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglass", "eyewear"},
                {"green_hat", "headgear"}
        };

        System.out.println(solution(clothes));
    }
}
