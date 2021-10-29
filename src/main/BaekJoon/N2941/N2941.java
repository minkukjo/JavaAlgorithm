package main.BaekJoon.N2941;

import java.util.Scanner;

public class N2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.replace("c=", "1");
        str = str.replace("c-", "1");
        str = str.replace("dz=", "1");
        str = str.replace("d-", "1");
        str = str.replace("lj", "1");
        str = str.replace("nj", "1");
        str = str.replace("s=", "1");
        str = str.replace("z=", "1");

        System.out.println(str.length());
    }
}
