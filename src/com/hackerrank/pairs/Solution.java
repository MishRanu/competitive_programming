package pairs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 11-Jul-17.
 */




public class Solution {

    public static void countKs(int[] array, int k) {
        int count = 0;
        int i = array.length - 1;

        while (i >= 0 && array[i] > k) {
            int diff = array[i]-k;
            int index = Arrays.binarySearch(array, 0, i + 1, diff);
            if (index > 0) {
                count++;
                int lindex = index-1;
                int rindex = index+1;
                while(array[lindex]==diff&&index>=0){
                    count++;
                }
                while(array[rindex]==diff&&rindex>=i){
                    count++;
                }
            }
            else if(index==0){
                count++;
                index++;
                while(array[index]==diff&&index<=i){
                    count++;
                }
            }
            i--;

        }
        System.out.print(count);
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int k = stdin.nextInt();
        int[] array = new int[n];
        for(int i =0; i<n; i++){
            array[i] = stdin.nextInt();
        }
        Arrays.sort(array);
        countKs(array, k);
    }
}
