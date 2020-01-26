package main.Hash.Runner;

import java.util.HashMap;

public class Runner {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String a: completion){
            if(hashMap.containsKey(a)){
                hashMap.put(a,hashMap.get(a)+1);
            }else{
                hashMap.put(a,1);
            }

        }

        for(String a: participant){
            if(hashMap.containsKey(a) && hashMap.get(a) != 0){
                hashMap.put(a,hashMap.get(a)-1);
            }
            else{
                answer = a;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] input = {"leo", "kiki","leo", "eden"};
        String[] completion = {"eden","kiki","leo"};
        System.out.println(solution(input,completion));
    }
}
