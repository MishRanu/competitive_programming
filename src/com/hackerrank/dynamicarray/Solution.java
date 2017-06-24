package dynamicarray;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int q = stdin.nextInt();
        List<ArrayList<Integer>> seq = new ArrayList<>();
        for(int i=0; i<n; i++) {
            seq.add(new ArrayList<Integer>());
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int lastAnswer = 0;
        for(int i=0; i<q;  i++){
//            System.out.println("last answer "+ lastAnswer);
            int opt = stdin.nextInt();
            if(opt==1){
                int x= stdin.nextInt();
                int seqn = (x^lastAnswer)%n;
                seq.get(seqn).add(stdin.nextInt());
            }
            else if(opt==2){
                int x = stdin.nextInt();
                int seqn = (x^lastAnswer)%n;
                lastAnswer = seq.get(seqn).get(stdin.nextInt()%seq.get(seqn).size());
                answer.add(lastAnswer);
            }
        }
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}
