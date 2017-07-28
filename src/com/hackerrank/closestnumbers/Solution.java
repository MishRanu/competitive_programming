package closestnumbers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 08-Jul-17.
 */


class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static int diff(int x, int y){
        return Math.max(x, y) - Math.min(x,y);
    }

    @Override
    public String toString() {
        String value = x + " " + y;
        return value;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = stdin.nextInt();
        }
        Arrays.sort(array);
        ArrayList<Pair> pairs = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i+1]-array[i] < min) {
                pairs.clear();
                min = array[i+1] - array[i];
                pairs.add(new Pair(array[i], array[i + 1]));
            } else if (array[i+1]-array[i] == min) {
                pairs.add(new Pair(array[i], array[i + 1]));
            }
        }

        for (Pair pair : pairs) {
            System.out.print(pair + " ");
        }
    }

}