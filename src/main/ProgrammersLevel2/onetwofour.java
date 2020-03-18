package main.ProgrammersLevel2;

public class onetwofour {
    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n>0){
            int reminder = n%3;
            n = n/3;

            if(reminder == 0){
                reminder = 4;
                n -=1;
            }

            answer.append(reminder);
        }
        return answer.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(113));
    }
}
