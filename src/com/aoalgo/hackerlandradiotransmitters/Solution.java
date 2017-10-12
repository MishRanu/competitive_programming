package hackerlandradiotransmitters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by User on 11-Jul-17.
 */
public class Solution {

    public boolean checkRemove(int[] city, int[] array, int index, int k){
        int lj = index-1;
        int rj = index+1;
        int ldecrement =k;
        int rdecrement =k;

        int [] newCity = new int[city.length];
        for(int i=0; i<city.length; i++){
            newCity[i] = city[i];
        }
        newCity[index]-=ldecrement+1;
        while(lj>=0&&lj>=index-k){
            newCity[lj]-= ldecrement;
            lj--;
            ldecrement--;
        }
        while(rj<city.length&&rj<=index+k){
            newCity[rj]-= rdecrement;
            rj++;
            rdecrement--;
        }

        for(int i=0; i<array.length; i++){
            if(newCity[array[i]]<0) {
                return false;
            }
        }
        for(int i=0; i<newCity.length; i++){
            city[i] = newCity[i];
        }
        return true;
    }


    public void setup(int[] city, int index, int k){
        int lj = index-1;
        int rj = index+1;
        int lincrement = k;
        int rincrement = k;
        city[index]+= lincrement+1;
        while(lj>=0&&lj>=index-k){
            city[lj]+= lincrement;
            lj--;
            lincrement--;
        }
        while(rj<city.length&&rj<=index+k){
            city[rj]+= rincrement;
            rj++;
            rincrement--;
        }
    }

    public static void printArray(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] valNum = in.readLine().split(" ");
        int n = Integer.parseInt(valNum[0]);
        int k = Integer.parseInt(valNum[1]);

//        Set<Integer> ar = new HashSet<>();
        String[] values = in.readLine().split(" ");
        int[] x = new int[n];
         for(int x_i = 0; x_i<n; x_i++){
//             ar.add(Integer.parseInt(values[x_i]));
                x[x_i] = Integer.parseInt(values[x_i]);
         }

//        int[] array = new int[ar.size()];
//        int i=0;
//
//        Solution solution = new Solution();
//        for(Integer element: ar){
//            array[i] = element;
//            i++;
//        }

        Arrays.sort(x);
        int numOfTransmitters = 0;
        int i = 0;
        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k;
            while (i < n && x[i] <= loc) i++;
        }
        System.out.println(numOfTransmitters);
//
//        Arrays.sort(array);
//        int max = array[array.length-1];
//        int [] city = new int[max+2];
//        Arrays.fill(city, -1);
//        for(i=0; i<array.length; i++){
//            solution.setup(city,array[i], k);
//        }
//
//        int count=0;
//        for(i=0; i<array.length; i++){
//            if(solution.checkRemove(city, array, array[i], k)){
//                count++;
//            }
//        }
//        System.out.println(array.length-count);

    }
}
