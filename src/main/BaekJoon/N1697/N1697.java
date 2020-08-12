package main.BaekJoon.N1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Subin{
    int point;
    int time;

    public Subin(int point, int time){
        this.point = point;
        this.time = time;
    }

}

public class N1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();
        int ans = 0;

        Queue<Subin> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        q.offer(new Subin(start,0));

        while(!q.isEmpty()){
            Subin temp = q.poll();
            visit[temp.point] = true;

            if(temp.point == goal){
                ans = temp.time;
                break;
            }


            if(temp.point-1 >= 0 && !visit[temp.point-1]){
                q.offer(new Subin(temp.point-1,temp.time+1));
            }
            if(temp.point+1 <= 100000 && !visit[temp.point+1] ){
                q.offer(new Subin(temp.point+1,temp.time+1));
            }
            if(temp.point*2 <= 100000 && !visit[temp.point*2]){
                q.offer(new Subin(temp.point*2,temp.time+1));
            }
        }

        System.out.println(ans);

    }
}
