package maximumsumsubarray;
import java.util.Scanner;

/**
 * Created by User on 17-Aug-17.
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        int[] solution = new int[n];
        int max = Integer.MIN_VALUE;
        solution[1] = a[1];
        for(int i=1; i<n; i++){
            if(solution[i-1]>0){
                solution[i]= solution[i-1] + a[i];
            }
            else{
                solution[i] = a[i];
            }
            if(solution[i]>max)
                max = solution[i];
        }
        System.out.println(max);
    }

}
