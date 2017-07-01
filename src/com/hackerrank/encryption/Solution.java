package encryption;

import java.util.Scanner;

/**
 * Created by User on 01-Jul-17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        StringBuffer input = new StringBuffer(stdin.next());
        int lowerBound = (int) Math.floor(Math.sqrt((double) input.length()));
        int upperBound = (int) Math.ceil(Math.sqrt((double) input.length()));
        int prod = Integer.MAX_VALUE;
        int opt_x = 0, opt_y = 0;
        for (int x = lowerBound; x <= upperBound; x++) {
            for (int y = lowerBound; y <= upperBound; y++) {
                if (x <= y && x * y >= input.length()) {
                    if (prod > x * y) {
                        prod = x * y;
                        opt_x = x;
                        opt_y = y;
                    }
                }
            }
        }

        for(int j=0; j<opt_y; j++){
            for(int i=0; i<opt_x; i++){
                if(j+opt_y*i<input.length()){
                    System.out.print(input.charAt(j+i*opt_y));
                }
            }
            System.out.print(" ");
        }

    }
}
