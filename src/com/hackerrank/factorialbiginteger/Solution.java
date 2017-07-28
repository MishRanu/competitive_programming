package factorialbiginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by User on 30-Jun-17.
 */
public class Solution {



    public static BigInteger factorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for(int i=1; i<=n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        System.out.print(factorial(n));
    }


}
