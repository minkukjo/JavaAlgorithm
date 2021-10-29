package main.StackandQueues.Printer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    예전엔 못풀었던 문제였는데 풀리네..
    실력이 늘긴 했나보다!
    앞으로도 자바로 계속 정진해나가자
 */

class Document {
    int index;
    int data;

    Document(int index, int data) {
        this.index = index;
        this.data = data;
    }
}

public class Printer {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            }
            return 0;
        });
        Queue<Document> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Document(i, priorities[i]));
            pq.offer(priorities[i]);
        }


        while (!q.isEmpty() && !pq.isEmpty()) {
            Document target = q.poll();
            if (target.data < pq.peek()) {
                q.add(target);
            } else {
                pq.poll();
                answer++;
                if (target.index == location) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(arr, location));
    }
}
