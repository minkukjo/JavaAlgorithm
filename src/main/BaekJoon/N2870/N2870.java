package main.BaekJoon.N2870;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N2870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        ArrayList<BigInteger> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            str[i] = sc.next();
        }

        for(int i=0; i<n; i++){
            boolean combo = false;
            String temp = "";
            for(int j=0; j<str[i].length(); j++){
                if(combo && str[i].charAt(j) >= 48 && str[i].charAt(j) <= 57) {
                    temp += str[i].charAt(j);
                }else if(!combo && str[i].charAt(j) >= 48 && str[i].charAt(j) <= 57){
                    temp += str[i].charAt(j);
                    combo = true;
                }else if(combo && (str[i].charAt(j) <= 48 || str[i].charAt(j) >= 57) ){
                    list.add(new BigInteger(temp));
                    temp = "";
                    combo = false;
                }
            }
            if(combo){
                list.add(new BigInteger(temp));
            }
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
