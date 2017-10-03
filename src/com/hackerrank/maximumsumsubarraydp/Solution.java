package maximumsumsubarraydp;

import java.util.Scanner;

/**
 * Created by User on 15-Aug-17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = stdin.nextInt();
        }
        int[][] maxsum = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(i==j){
                    maxsum[i][j] = a[i];
                }
                else {
                    maxsum[i][j] = a[i] + maxsum[i + 1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maxsum[i][j] + " ");
            }
            System.out.println();

        }
    }
}
