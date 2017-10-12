package com.hackerrank.birthdaycakecandles;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long height[] = new long[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextLong();
        }
        Arrays.sort(height);
        long max = height[n-1];
        long max_count=1;
        for(int height_i=n-2; height_i >= 0; height_i--){
            if(height[height_i]==max){
                max_count++;
            }
        }
        System.out.print(max_count);
    }
}
