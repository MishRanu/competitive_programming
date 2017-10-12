package median;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 11-Jul-17.
 */
public class Solution {
    public static void main(String[] args){

        Scanner stdin  = new Scanner(System.in);
        int n= stdin.nextInt();
        int[] ar = new int[n];
        for(int i=0; i<n; i++){
            ar[i] = stdin.nextInt();
        }
        Arrays.sort(ar);

        System.out.print(ar[n/2]);
    }
}
