package main.ProgrammersLevel2;

import java.util.Stack;

public class BracketConversion {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    public static boolean validate(String v){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<v.length(); i++){
            if(v.charAt(i) == ')' && stack.isEmpty()){
                return false;
            }
            else if(v.charAt(i) == ')'){
                stack.pop();
            }
            else{
                stack.push('(');
            }
        }

        return true;
    }

    public static int division(String w){
        int open = 0,close = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            if(open == close){
                return i+1;
            }
        }
        return w.length()-1;
    }

    public static String make(String p){
        if(p.isEmpty()){
            return "";
        }
        int division = division(p);
        String u = p.substring(0,division);
        String v = p.substring(division);

        if(validate(u)){
            return u + make(v);
        }else{
            String temp = '(' + make(v) + ')';
            u = u.substring(1,u.length()-1);
            u = reverse(u);
            return temp+u;
        }
    }

    private static String reverse(String u) {
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                temp.append(')');
            }else{
                temp.append('(');
            }
        }
        return temp.toString();
    }

    private static String solution(String p) {
        String answer = "";
        if(p.isEmpty()){
            return  "";
        }
        if(validate(p)){
            return p;
        }

        answer = make(p);



        return answer;
    }
}
