package main.BaekJoon.N2869;

import java.util.Scanner;

/*
    달팽이는 올라가고 싶다.
    낮에 A만큼 올라가고 밤에 B만큼 내려감
    V라는 막대기 정상에 도달하는데 걸리는 날짜는?
 */
public class N2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double A = sc.nextDouble();
        Double B = sc.nextDouble();
        Double V = sc.nextDouble();

        if(V.equals(A)){
            System.out.println(1);
        }
        else{
            System.out.println( (int)Math.ceil((V-A)/(A-B))+1 );
        }
    }
}
