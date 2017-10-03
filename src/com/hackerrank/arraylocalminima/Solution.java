package arraylocalminima;

import java.util.Scanner;

/**
 * Created by User on 17-Aug-17.
 */
public class Solution {


    public static boolean checkLocal(int []a, int mid){
        if(mid==0&&a[mid+1]>a[mid]||mid==a.length-1&&a[mid-1]>a[mid])
            return true;
        else if(a[mid-1]>a[mid]&&a[mid+1]>a[mid])
        return true;
        else return false;
    }
    public static int findLocalMinima(int [] a, int i, int j){
        int l= i;
        int r= j;
        int mid = (l+r)/2;
        boolean found= false;
        while(l<=r&&!found) {

            mid = (l+r)/2;
            if (checkLocal(a, mid))
                found = true;
            else if (a[mid + 1] < a[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return a[mid];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] =in.nextInt();
        }

        System.out.println(findLocalMinima(a, 0, a.length-1));

    }
}
