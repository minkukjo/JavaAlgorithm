package main.Heap.RamenFactory;

import java.util.PriorityQueue;

class Supply implements Comparable<Supply> {
    private int supply;
    private int dates;

    public Supply(int dates, int supply) {
        this.supply = supply;
        this.dates = dates;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }

    @Override
    public int compareTo(Supply o) {
        if(this.supply < o.supply){
            return 1;
        }else if(this.supply > o.supply){
            return -1;
        }
        return 0;
    }
}

public class RamenFactory {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Supply> pq = new PriorityQueue<>();

        int day = stock;
        int days = 0;

        while(day < k){
            while(days < dates.length && dates[days] <= day){
                pq.add(new Supply(dates[days],supplies[days]));
                days++;
            }
            answer++;
            day += pq.poll().getSupply();
        }


        return answer;
    }

    public static void main(String[] args) {
        int stock = 4;
        int stock3 = 10;
        int[] dates = {4, 10, 15};
        int[] dates2 = {1, 2, 3,4};
        int[] dates3 = {5,10};
        int[] supplies = {20, 5, 10};
        int[] supplies2 = {10,40,30,20};
        int[] supplies3 = {1,100};
        int k = 30;
        int k2 = 100;
        int k3 = 110;
        System.out.println(solution(stock,dates,supplies,k));
    }
}
