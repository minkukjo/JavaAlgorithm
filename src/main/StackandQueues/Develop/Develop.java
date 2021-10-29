package main.StackandQueues.Develop;

import java.util.*;

/*
    프로그래머스
 */
public class Develop {
    public static int[] using_queue(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add((100 - progresses[i]) / speeds[i]);
        }

        int cnt = 1;
        int minday = q.poll();
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num <= minday) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                minday = num;
            }
        }
        list.add(cnt);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 큐를 사용하지 않고 해결
        int[] answer = {};
        int days = 1;
        int[] endDay = new int[101];
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (days * speeds[i]) < 100) {
                days++;
            }
            endDay[days]++;
        }

        return Arrays.stream(endDay).filter(i -> i != 0).toArray();
    }

    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] speed = {1, 30, 5};

        int[] p2 = {40, 93, 30, 55, 60, 65};
        int[] speed2 = {60, 1, 30, 5, 10, 7};

        int[] answer = using_queue(p2, speed2);


        for (int a : answer) {
            System.out.println(a);
        }

    }
}
