package leftrotation;

import java.util.Scanner;

/**
 * Created by User on 24-Jun-17.
 */
public class Solution {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int d = stdin.nextInt();
        int[] a = new int[n];
        int[] shifted_a = new int[n];
        for (int i = 0; i < n; i++) {
            int i_new = (i-d<0)?(i-d+n)%n:(i-d)%n;
            a[i_new] = stdin.nextInt();
        }

//        for (int i = 0; i < n; i++) {
//            shifted_a[(i + d + n) % n] = a[i];
//        }

        for(int i=0; i<n; i++){
            System.out.printf("%d ", a[i]);
        }
//        System.out.println(shifted_a.toString());
    }
}
