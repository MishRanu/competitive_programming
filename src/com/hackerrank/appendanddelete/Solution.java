package appendanddelete;

/**
 * Created by User on 30-Jun-17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int commonStringLength(String a, String b){
        int al = a.length();
        int bl = b.length();
        boolean flag = true;
        int i=0;
        while((i<Math.min(al, bl))&&flag){
            if(a.substring(0,i+1).equals(b.substring(0,i+1))){
                i++;
            }
            else {
                flag = false;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        int csl = commonStringLength(s,t);
        int min = s.length() + t.length() - 2*csl;
        int moves = min;
        String solve = "No";
        boolean flag =true;
        if(k>=moves&&(k-moves)%2==0){
            solve= "Yes";
        }
        else if(k>=s.length()+ t.length()) {
            solve = "Yes";
        }
        System.out.print(solve);

    }

}

