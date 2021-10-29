package main.StackandQueues.Stock;

/*
    뭐지..? 이게 왜 스택 큐 문제야?
 */

public class Stock {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int ansCount = 0;
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[ansCount++] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3};
        int[] answer = solution(arr);
        for (int a : answer) {
            System.out.println(a);
        }
    }
}
