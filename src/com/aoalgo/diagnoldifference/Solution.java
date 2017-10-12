package com.hackerrank.diagnoldifference;

import java.util.Scanner;

/**
 * Created by User on 05-Jun-17.
 */
public class Solution {

    public static void main(String[] args){
        long primarySum=0;
        long secondarySum=0;
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = stdin.nextInt();
                if(i==j){
                    primarySum = primarySum + num;
                }
                if(i==n-j-1){
                    secondarySum = secondarySum + num;
                }
            }
        }
        long answer = 0;
        if(primarySum-secondarySum>0){
            answer= primarySum-secondarySum;
        }
        else {
            answer = secondarySum- primarySum;
        }
        System.out.println(answer);
    }


}
