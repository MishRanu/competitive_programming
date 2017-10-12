package absumkproblem;


import java.util.Scanner;

/**
 * Created by User on 17-Aug-17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int k = in.nextInt();
        int l = 0;
        int r = a.length-1;
        boolean found = false;
        while(l<=r&&!found){
            if(a[l]+a[r]>k){
                  r--;
            }
            else if(a[l]+a[r]<k){
                l++;
            }
            else{
                found=true;
            }
        }
        if(found)
        System.out.printf("%d %d", a[l], a[r]);
        else
            System.out.print("Not found");
    }
}