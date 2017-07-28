package fullcountingsort;

import java.io.*;
import java.util.Scanner;

/**
 * Created by User on 05-Jul-17.
 */
public class Solution {
    public static void printArray(int[] a){
        for(int item: a){
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
//        Scanner stdin = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
//        int n = stdin.nextInt();
        int[] count  = new int [100];
        String[][] input = new String[n][2];
        String[] output = new String[n];
        for(int i=0; i<n; i++){
            String[] line = in.readLine().split(" ");
            int index = Integer.parseInt(line[0]);
            input[i][0] = String.valueOf(index);
            input[i][1]= line[1];
            count[index]++;
        }
        for(int i=1; i<100; i++){
            count[i]+= count[i-1];
        }
        for(int i=n-1; i>=0; i--){

            int inputIndex = Integer.parseInt(input[i][0]);
            if(i<n/2){

                output[count[inputIndex]-1] = String.valueOf('-');
                --count[inputIndex];
            }
            else{
                output[count[inputIndex]-1] = input[i][1];
                --count[inputIndex];
            }
        }

        for(int i=0; i<n; i++){
            out.write(output[i]+" ");
//            System.out.printf("%s ", output[i]);
        }
            out.flush();
    }
}
