package icecreamparlor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 11-Jul-17.
 */
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;

    }
    public String toString(){
        return x + " " + y;
    }
}

public class Solution {
    ArrayList<Pair> answers = new ArrayList<>();
    public Pair getAnswer(int[] prices, int k){
         for(int price: prices){
             price = k-price;
         }
         int j=1, i;
         for(i=1; i<=prices.length; i++){
             if(prices[i]>0){
                 boolean found = false;
                 j=1;
                 while(!found&&j<prices.length){
                     if(prices[i]+prices[j]==k&&i!=j){
                        found = true;
                     }
                     else{
                         j++;
                     }
                 }
                 if(found) break;
             }

         }
         return new Pair(i,j);
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();

        Solution solution = new Solution();
        for(int i=0; i<t; i++){
            int k = stdin.nextInt();
            int n = stdin.nextInt();
            int [] prices = new int[n+1];
            for(int j=1; j<=n; j++){
                prices[j] = stdin.nextInt();
            }
            solution.answers.add(solution.getAnswer(prices, k));
        }

        for(int i=0; i<t; i++){
            System.out.println(solution.answers.get(i));
        }
    }
}
