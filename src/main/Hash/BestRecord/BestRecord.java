package main.Hash.BestRecord;

import java.util.*;

public class BestRecord {
    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, TreeMap<Integer, Integer>> treeMap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
                TreeMap<Integer, Integer> temp = treeMap.get(genres[i]);
                temp.put(i, plays[i]);
                treeMap.put(genres[i], temp);
            } else {
                hashMap.put(genres[i], plays[i]);
                TreeMap<Integer, Integer> temp = new TreeMap<>(Collections.reverseOrder());
                temp.put(i, plays[i]);
                treeMap.put(genres[i], temp);
            }
        }

        int[] answer;

        List<String> keySetList = new ArrayList<>(hashMap.keySet());

        keySetList.sort((o1, o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1))));

        for (String key : keySetList) {
            int i = 0;
            List<Integer> treeKeyList = new ArrayList<>(treeMap.get(key).keySet());

            treeKeyList.sort((o1, o2) -> {
                if (treeMap.get(key).get(o1).equals(treeMap.get(key).get(o2))) {
                    return -1;
                } else {
                    return treeMap.get(key).get(o2).compareTo(treeMap.get(key).get(o1));
                }
            });

            for (int index : treeKeyList) {
                if (i == 2) break;
                if (treeKeyList.size() == 0) break;
                if (treeKeyList.size() == 1) {
                    ans.add(index);
                    break;
                } else {
                    ans.add(index);
                }
                i++;
            }
        }

        answer = ans.stream().mapToInt(x -> x).toArray();

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        String[] genres2 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {400, 600, 150, 2500, 500, 500};
        int[] plays2 = {500, 600, 150, 800, 2500};
        int[] answer = solution(genres, plays);
        for (int a : answer) {
            System.out.println(a);
        }
    }
}
