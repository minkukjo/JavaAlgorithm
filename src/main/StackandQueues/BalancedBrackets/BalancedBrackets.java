package main.StackandQueues.BalancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return "NO";
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "NO";
                }
                stack.pop();
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.empty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
            String s = sc.next();

            String result = isBalanced(s);
            System.out.println(result);
        }

    }
}
