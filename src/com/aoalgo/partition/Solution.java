package partition;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 04-Jul-17.
 */
public class Solution {
    private int a[];
    public void swap(int l, int r){
        int temp  = a[l];
        a[l]=a[r];
        a[r]=temp;
    }

    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int partitionCLRS(int a[],int low, int high){
        int pivot = a[low];
        int i = low;
        for(int j=low+1; j<=high; j++){
            if(a[j]<pivot){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i,low);
        return i;
    }

    public int [] partition(){
        int pivot = a[0];
        int l=0;
        int r= a.length-1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        for(int item: a){
            if(item<pivot){
                left.add(item);
            }
            else if(item>pivot){
                right.add(item);
            }
            else{
                equal.add(item);
            }
        }
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(left);
        array.addAll(equal);
        array.addAll(right);
        for(int i=0; i<array.size(); i++){
            a[i] = array.get(i);
        }
        return a;
    }
    public static void printArray(int[] a){
        for(int item: a){
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Solution solution = new Solution();
        int n = stdin.nextInt();
        solution.a = new int[n];
        for(int i=0; i<n; i++){
            solution.a[i] = stdin.nextInt();
        }
        solution.partitionCLRS(solution.a, 0, n-1);
        printArray(solution.a);
    }
}
