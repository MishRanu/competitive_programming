package runningtimequicksort;

import java.util.Scanner;

/**
 * Created by User on 05-Jul-17.
 */
public class Solution {
    int[] insertionsortArray;
    int[] quicksortArray;
    int insertionCount;
    int quicksortCount;

    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
        quicksortCount++;
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

    public void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for(int i=1; i<ar.length; i++){
            int temp = ar[i];
            int j=i-1;
            while(j>=0&&ar[j]>temp){
                ar[j+1] = ar[j];
                insertionCount++;
                j--;
            }
            ar[j+1]=temp;
//            insertionCount++;
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Solution solution = new Solution();

        solution.quicksortArray = new int[n];
        solution.insertionsortArray = new int[n];
        for(int i =0; i<n; i++) {
            int num = stdin.nextInt();
            solution.quicksortArray[i] = num;
            solution.insertionsortArray[i] = num;
        }

        solution.quicksort(solution.quicksortArray, 0, solution.quicksortArray.length-1);
        solution.insertionSortPart2(solution.insertionsortArray);
//        printArray(solution.a);
        System.out.println(solution.insertionCount-solution.quicksortCount);

    }


}
