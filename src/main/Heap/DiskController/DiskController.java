package main.Heap.DiskController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Disk implements Comparable<Disk>{
    int waitTime;
    int executeTime;

    @Override
    public int compareTo(Disk o) {
        return this.executeTime - o.executeTime;
    }

    public Disk(int waitTime, int executeTime) {
        this.waitTime = waitTime;
        this.executeTime = executeTime;
    }
}

public class DiskController {
    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Disk> pq = new PriorityQueue<>();

        int idx = 0;
        int cur = 0;
        int total  = 0;
        while(true){
            while(idx < jobs.length && jobs[idx][0] <= cur){
                pq.add(new Disk(jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            if(pq.isEmpty()){
                if(idx == jobs.length){
                    break;
                }else{
                    cur++;
                }
            }else{
                Disk temp = pq.poll();
                cur += temp.executeTime;
                total += cur-temp.waitTime;
            }
        }

        answer = total/jobs.length;



        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = {
                {0,3},
                {1,9},
                {2,6}
        };

        int[][] jobs2 = {
                {24,10},
                {18,39},
                {34,20},
                {37,5},
                {47,22},
                {20,47},
                {15,2},
                {15,34},
                {35,43},
                {26,1}
        };

        System.out.println(solution(jobs2));
    }
}
