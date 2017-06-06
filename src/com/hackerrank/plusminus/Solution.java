package com.hackerrank.plusminus;

import java.util.Scanner;

/**
 * Created by User on 05-Jun-17.
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int positive=0, negative=0, zero=0;
        for(int i=0; i<n; i++) {
            int num = in.nextInt();
            if (num < 0) {
                negative++;
            } else if (num > 0) {
                positive++;
            } else {
                zero++;
            }
        }

        System.out.println((float)positive/n);
        System.out.println((float)negative/n);
        System.out.println((float)zero/n);
    }
}
