package hourglasssum;

import java.util.Scanner;

/**
 * Created by User on 07-Jun-17.
 */
public class Solution {
    static int hourglasssum(int [][]a, int i, int j){
        return a[i][j] + a[i-1][j] + a[i-1][j-1] + a[i-1][j+1] + a[i+1][j] + a[i+1][j-1] + a[i+1][j+1];
    }
    public static void main(String[] args) {
        int[][] a = new int[6][6];
        Scanner stdin = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = stdin.nextInt();
            }
        }
        int max_sum = Integer.MIN_VALUE;
        for(int i=1; i<5; i++){
            for(int j=1; j<5; j++){
                max_sum = Math.max(max_sum, hourglasssum(a, i, j));
            }
        }
        System.out.print(max_sum);
    }


}
