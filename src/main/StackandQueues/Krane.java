package main.StackandQueues;

import java.util.*;

public class Krane {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        List<Queue<Integer>> queues = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            queues.add(new LinkedList<>());
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++){
                if(board[i][j] != 0){
                    queues.get(j).add(board[i][j]);
                }
            }
        }

        for(int i=0; i<moves.length; i++){
            int move = moves[i] - 1;
            Queue<Integer> dolls = queues.get(move);
            if(!dolls.isEmpty()){
                Integer doll = dolls.poll();
                if(!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                }else {
                    basket.add(doll);
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board,moves));
    }
}
