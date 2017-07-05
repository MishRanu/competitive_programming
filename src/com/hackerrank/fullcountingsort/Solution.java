package fullcountingsort;

import java.util.Scanner;

/**
 * Created by User on 05-Jul-17.
 */
public class Solution {
    public static void printArray(int[] a){
        for(int item: a){
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Solution solution  = new Solution();
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int[] a  = new int [100];
        for(int i=0; i<n; i++){
            int num = stdin.nextInt();
            a[num]++;
        }
        for(int i=0; i<100; i++) {
            if (a[i] != 0) {
                for(int k=0; k<a[i]; k++)
                System.out.printf("%d ", i);
            }
        }
    }
}
