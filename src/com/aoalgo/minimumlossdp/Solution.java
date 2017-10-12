package minimumlossdp;


import java.util.Scanner;

/**
 * Created by User on 12-Jul-17.
 */
public class Solution {
    int[][] losses;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] prices = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = in.nextInt();
        }
        Solution solution = new Solution();
        solution.losses = new int[n][n];
        int minLoss = Integer.MIN_VALUE;
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                solution.losses[i][j] = solution.losses[i+1][j]-prices[i]+prices[i+1];
                if(solution.losses[i][j]<0){
                    if(solution.losses[i][j]>minLoss){
                        minLoss = solution.losses[i][j];
                    }
                }
            }
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(solution.losses[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(-minLoss);
    }
}
