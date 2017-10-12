package missingnumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by User on 11-Jul-17.
 */
public class Solution {
    int [] mapA = new int[100];
    int [] mapB = new int[100];

    public int[] constructMap(int [] array, int min){
        int[] map = new int[100];
        for(int element:array){
            ++map[element-min];
        }
        return map;
    }
    public void compareMaps(int[] mapA, int [] mapB, int min){
        for(int i=0; i<100; i++){
            if(mapA[i]!=mapB[i]){
                System.out.print(min+i);
                System.out.print(" ");
            }
        }

    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int [] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = stdin.nextInt();
        }
        int m = stdin.nextInt();
        int [] B = new int[m];

        for(int i =0; i<m; i++){
            B[i] = stdin.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int A_min = A[0];
        int A_max = A[A.length-1];
        int B_min = B[0];
        int B_max = B[B.length-1];
        Solution solution = new Solution();
        solution.mapA = solution.constructMap(A, B_min);
        solution.mapB = solution.constructMap(B, B_min);

        solution.compareMaps(solution.mapA, solution.mapB, B_min);
    }
}
