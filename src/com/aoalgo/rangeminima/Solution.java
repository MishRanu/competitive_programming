package rangeminima;

import java.util.Scanner;

/**
 * Created by User on 16-Aug-17.
 */
public class Solution {

    public static int rangeminima(int[] a, int i, int j){
        return 0;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] a = new int [n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        int t = in.nextInt();
        for(int i=0; i<t; i++){
            System.out.println(rangeminima(a, in.nextInt(), in.nextInt()));
            
        }
    }
}
