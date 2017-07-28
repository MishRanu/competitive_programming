package minimumlossarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by User on 13-Jul-17.
 */



public class Solution {
    public void swap(int a[][], int i, int j){
        int temp = a[i][0];
        int temp_index = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0]= temp;
        a[j][1] = temp_index;
    }

    public int partition(int a[][] , int low, int high){
        int pivot = a[high][0];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(a[j][0]<pivot){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, high);
        return i+1;
    }

    public void quicksort(int[][] a, int low, int high){
        if(low<high) {
            int pivotIndex = partition(a, low, high);
            quicksort(a, low, pivotIndex-1);
            quicksort(a, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        int[][] prices = new int[n][2];
        String[] values = stdin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            prices[i][0] = Integer.parseInt(values[i]);
            prices[i][1] = i;

        }
        Solution solution = new Solution();
        solution.quicksort(prices, 0, prices.length-1);
        int currPrice=Integer.MIN_VALUE;
        int currPriceIndex = 0;
        int prvsPrice=Integer.MAX_VALUE;
        int prvsPriceIndex= 0;
        int minDiff = Integer.MAX_VALUE;
        for (int[] price: prices) {
            if(currPrice==Integer.MIN_VALUE){
                currPrice = price[0];
                currPriceIndex= price[1];
            }
            else{
                prvsPrice = currPrice;
                prvsPriceIndex = currPriceIndex;
                currPrice = price[0];
                currPriceIndex = price[1];
                if(minDiff>currPrice-prvsPrice&&currPriceIndex<prvsPriceIndex)
                {
                    minDiff = currPrice-prvsPrice;
                }
            }

        }
        System.out.print(minDiff);
    }
}
