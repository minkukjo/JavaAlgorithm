package main.StackandQueues.Top;

import java.util.Scanner;
import java.util.Stack;

/*
    프로그래머스
 */
public class Top {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=heights.length-1; i>=0; i--){
            boolean isFind = false;
            for(int j=i-1; j>=0; j--){
                if(heights[i] < heights[j]){
                    isFind = true;
                    stack.push(j+1);
                    break;
                }
            }
            if(!isFind){
                stack.push(0);
            }
        }

        int i= 0;
        while(!stack.empty()){
            answer[i++] = stack.pop();
        }

        return answer;
    }
    public static void main(String[] args) {

        int[] arr = {6,9,5,7,4};
        int[] ans;
        ans = solution(arr);

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }

    }
}
