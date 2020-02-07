package main.BaekJoon.N10773;

import java.util.Scanner;
import java.util.Stack;

public class N10773 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        long total = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int temp = sc.nextInt();
            if(temp == 0 && !stack.isEmpty()){
                stack.pop();
            }
            else if(temp != 0){
                stack.push(temp);
            }
        }

        while(!stack.isEmpty()){
            total += stack.pop();
        }

        System.out.println(total);
    }
}
