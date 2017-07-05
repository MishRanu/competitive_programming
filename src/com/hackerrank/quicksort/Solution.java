package quicksort;

import java.util.Scanner;

/**
 * Created by User on 05-Jul-17.
 */
public class Solution {
    int[] a;
    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }
    public int partition(int a[] , int low, int high){
        int pivot = a[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(a[j]<pivot){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, high);
        return i+1;
    }

    public void quicksort(int[] a, int low, int high){
        if(low<high) {
            int pivotIndex = partition(a, low, high);
            printArray(a);
            quicksort(a, low, pivotIndex-1);
            quicksort(a, pivotIndex + 1, high);
        }
    }

    public static void printArray(int[] a){
        for(int item: a){
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Solution solution = new Solution();
        solution.a = new int[n];
        for(int i =0; i<n; i++) {
            solution.a[i] = stdin.nextInt();
        }
        solution.quicksort(solution.a, 0, solution.a.length-1);
//        printArray(solution.a);
    }
}
