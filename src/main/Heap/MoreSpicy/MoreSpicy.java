package main.Heap.MoreSpicy;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : scoville) {
            pq.add(a);
        }

        while (!pq.isEmpty() && pq.peek() <= K) {
            int first = pq.poll();
            if (pq.isEmpty()) return -1;
            int second = pq.poll();

            pq.add(first + (second * 2));
            answer++;
        }

        if (pq.isEmpty()) return -1;

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
