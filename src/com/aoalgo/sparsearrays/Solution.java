package sparsearrays;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by User on 28-Jun-17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        HashMap<String, Integer> inputStrings = new HashMap<>();
        stdin.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = stdin.nextLine();
            if (inputStrings.containsKey(temp)) {
                int value = inputStrings.get(temp);
                inputStrings.put(temp, value + 1);
            } else {
                inputStrings.put(temp, 1);
            }
        }

        int q= stdin.nextInt();
        stdin.nextLine();
        int [] answer = new int[q];
        for(int i=0; i<q; i++) {
            String temp = stdin.nextLine();
            if(inputStrings.containsKey(temp))
            {

                answer[i] = inputStrings.get(temp);
            }
            else {
                answer[i]=0;
            }

        }

        for(int i=0; i<q; i++) {
            System.out.println(answer[i]);
        }
    }

}
