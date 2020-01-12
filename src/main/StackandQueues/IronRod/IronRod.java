package main.StackandQueues.IronRod;

import java.util.ArrayList;
import java.util.Stack;

/*
    레이저를 0으로 치환해주고 왼쪽, 떨어져나간거 계산해주는 문제
 */

public class IronRod {
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arrangement.length(); i++){
            if( arrangement.charAt(i) == '('){
                stack.push(arrangement.charAt(i));
            }else if( arrangement.charAt(i) == ')'){
                stack.pop();
                answer++;
            }else if( arrangement.charAt(i) == '0'){
                answer += stack.size();
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String arg = "()(((()())(())()))(())".replace("()","0");
        System.out.println(solution(arg));
    }
}
