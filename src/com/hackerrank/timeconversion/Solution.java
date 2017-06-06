package com.hackerrank.timeconversion;

/**
 * Created by User on 06-Jun-17.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String time = stdin.nextLine();
        StringBuffer formatted_time = new StringBuffer("");
        int n = time.length();
//        System.out.println(n);
        if(time.substring(n-2, n).equals("PM")){
            Integer hour = Integer.parseInt(time.substring(0,2))%12 + 12;
            formatted_time.append(hour.toString());
            formatted_time.append(time.substring(2, n-2));
        }
        else {
            Integer hour = Integer.parseInt(time.substring(0,2))%12;
            if(hour<10){
                formatted_time.append(0);
            }
            formatted_time.append(hour.toString());
            formatted_time.append(time.substring(2, n-2));
        }
        System.out.println(formatted_time);
    }
}
