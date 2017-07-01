package permutation;

import java.util.Scanner;

/**
 * Created by User on 01-Jul-17.
 */
public class Solution {
    char[] input;

    Solution(String input){
        this.input = input.toCharArray();
    }

    private void swap(char[] input, int j, int k){
        char temp = input[j];
        input[j] = input[k];
        input[k] = temp;
    }


    private void permute(char[] input, int index, int n){
        if(index>=n)
            System.out.println(input);
        else {
            for (int i = index; i <= n; i++) {
                swap(input, index, i);
                permute(input, index + 1, n);
                swap(input, i, index);
            }
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Solution solution = new Solution(stdin.next());
        solution.permute(solution.input, 0, solution.input.length-1);

    }
}
