package binarysearch;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by User on 03-Jul-17.
 */
public class Solution {
    private int n;
    private int[] array;

    public int binarySearch(int searchValue) {
        int l = 0;
        int r = array.length;

        while (l <= r) {

            int mid = (l + r) / 2;
            if (array[mid] == searchValue)
                return mid;
            else {
                if (array[mid] < searchValue) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        int searchValue = stdin.nextInt();
        Solution solution = new Solution();
        solution.n = stdin.nextInt();
        solution.array = new int[solution.n];
        for (int i = 0; i < solution.n; i++) {
            solution.array[i] = stdin.nextInt();
        }
        System.out.print(solution.binarySearch(searchValue));
    }
}