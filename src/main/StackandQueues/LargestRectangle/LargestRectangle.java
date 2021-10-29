package main.StackandQueues.LargestRectangle;

import java.util.Scanner;
import java.util.Stack;

/*
    스택을 이용하는 알고리즘 문제였다.
    스택을 이용하라고 하니까 로직이 생각이 안나서 답지 본 문제.
    답지를 보고 나서야 문제를 이해했다.
 */

public class LargestRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while (i < h.length) {
            if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int height = h[p];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(height * width, max);
            }
        }

        while (!stack.empty()) {
            int p = stack.pop();
            int height = h[p];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;

            max = Math.max(height * width, max);

        }
    }
}
