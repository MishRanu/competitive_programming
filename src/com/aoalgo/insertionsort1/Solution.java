package insertionsort1;

import java.util.Scanner;

/**
 * Created by User on 03-Jul-17.
 */
public class Solution {
    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = stdin.nextInt();
        }
        boolean inserted = false;
        int temp=array[n-1];
        int i=n-2;
        while(!inserted&&i>=0) {
            if (temp > array[i]) {
                inserted = true;
                array[i+1]=temp;
            } else {
                array[i + 1] = array[i];
                i--;
                printArray(array);
            }
        }
        if(!inserted) {
            array[i+1] = temp;
        }

        printArray(array);
    }
}
