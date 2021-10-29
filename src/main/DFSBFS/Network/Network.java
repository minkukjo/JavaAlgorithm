package main.DFSBFS.Network;

import java.util.LinkedList;
import java.util.List;

public class Network {
    public static void dfs(List<Integer>[] lists, int start, boolean[] visit) {

        if (lists.length == 0) return;

        for (int i = 0; i < lists[start].size(); i++) {
            int temp = lists[start].get(i);
            if (!visit[temp]) {
                visit[temp] = true;
                dfs(lists, temp, visit);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] lists = new List[n];

        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j) {
                    if (computers[i][j] == 1) {
                        lists[i].add(j);
                    }
                }
            }
        }

        boolean visit[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(lists, i, visit);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(solution(3, computers));
    }
}
