package com.hackerrank.bigsum;

/**
 * Created by User on 05-Jun-17.
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum = sum + stdin.nextInt();
        }
        System.out.println(sum);
    }
}
