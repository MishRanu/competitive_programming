package com.hackerrank.minimaxsum;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        long sum =0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            long val = in.nextLong();
            max = Math.max(max, val);
            min = Math.min(min, val);
            sum = sum+ val;
        }
        System.out.println((sum - max) + " " + (sum - min));

    }
}