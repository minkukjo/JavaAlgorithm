package main.StackandQueues.Truck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int now_weight = 0;
        int i = 0;
        while(i < truck_weights.length){
            if(q.size() == bridge_length){
                now_weight -= q.poll();
            }
            else{
                if(weight >= truck_weights[i] + now_weight && q.size() < bridge_length){
                    q.add(truck_weights[i]);
                    now_weight += truck_weights[i];
                    i++;
                    answer++;
                }
                else{
                    q.add(0);
                    answer++;
                }
            }

        }
        answer = answer + bridge_length;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bridge_length = 2;
        int weight = 10;
        int[] arr = {7,4,5,6};

        System.out.println(solution(bridge_length,weight,arr));

    }
}
