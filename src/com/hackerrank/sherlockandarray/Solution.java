package sherlockandarray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 12-Jul-17.
 */
public class Solution {

    public static int processArray(int[] a, int sum){
        int index= 0;
        int rsum = sum-a[index];
        int lsum = 0;
        int l=-1;
        int r=a.length-1;
        if(index==r){
            return index;
        }
        while(index<r){
            if(lsum==rsum){
               return index;
            }
            else{
                l++;
                lsum+= a[index];
                index++;
                rsum-=a[index];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        ArrayList<String> answers= new ArrayList<>();
        for(int i=0; i<t; i++){
            int n = stdin.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for(int j=0; j<n; j++){
                int num = stdin.nextInt();
                a[j] = num;
                sum+=num;
            }
            if(processArray(a, sum)!=-1){
                answers.add("YES");
            }
            else{
                answers.add("NO");
            }
        }
        for(String answer: answers){
            System.out.println(answer);
        }
    }
}
