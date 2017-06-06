package com.interviewbit.arrays.spiralordermatrix;

/**
 * Created by User on 01-Jun-17.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        int top = 0;
        int down = a.size()-1;
        int left = 0;
        int right = a.get(0).size()-1;
        int dir = 0;
        while (top <= down && left <= right) {
            if (dir == 0) {
                int i = left;
                while (i <= right) {
                    result.add(a.get(top).get(i));
                    i++;
                }
                top++;
            }
            else if (dir == 1) {
                int i = top;
                while (i <= down) {
                    result.add(a.get(i).get(right));
                    i++;
                }
                right--;
            }
            else if (dir == 2) {
                int i = right;
                while (i >= left) {
                    result.add(a.get(down).get(i));
                    i--;
                }
                down--;
            }
            else if (dir == 3) {
                int i = down;
                while (i >= top) {
                    result.add(a.get(i).get(left));
                    i--;
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }
}
