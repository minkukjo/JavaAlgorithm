package main.BaekJoon.N2164;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        while(queue.size() != 1){
            queue.poll();
            int last = queue.poll();
            queue.add(last);
        }

        System.out.println(queue.peek());
    }
}
