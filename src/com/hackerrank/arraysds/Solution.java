package arraysds;

/**
 * Created by User on 07-Jun-17.
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = stdin.nextInt();
        }

        for(int i=n-1; i>0; i--){
            System.out.print(a[i]+" ");
        }
        System.out.print(a[0]);
    }
}