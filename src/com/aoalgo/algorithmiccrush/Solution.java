package algorithmiccrush;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 29-Jun-17.
 */
public class Solution {


    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        long m = stdin.nextLong();
        long[] num = new long[n+1];

        for (long i = 0; i < m; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            long k = stdin.nextLong();
            num[a] = num[a]+k;
            if(b+1<=n){
                num[b+1] = num[b+1]-k;
            }
        }
        long sum=0;
        long max = 0;
        for(int i=1; i<=n; i++){
            sum+=num[i];
            if(sum>max){
                max= sum;
            }
        }
        System.out.print(max);
    }
}
