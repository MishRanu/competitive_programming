package eightqueensstack;


import java.util.Scanner;
import java.util.Stack;

class Queen {
    int i;
    int j;
    Queen(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Solution {
    Stack<Queen> queenStack = new Stack<>();

    public boolean queenShadow(Queen newPosition){
        //This method will check if the queen held at the new position is clashing with any of ther
        // other queens currently in the stack
        // so i could either come with an external methods for having a look at all the elements currently in stack
        // I also need to write a method finding collision with newQueen with the other queens currently in the stack
        // if there is a collision with any of the other queens i return true
        // implementation of this method to be done later
        return true;
    }

    public boolean getEightQueenSolution(){
        boolean found = false;
        int i=0;
        int j=0;
        while(!found){
            int n=0;
            queenStack.push(new Queen(i,j));
            n++;
            int new_j = 0;
            while(!queenStack.isEmpty()){
                Queen newPosition = new Queen(i+1, new_j);
                if(queenShadow(newPosition))
                    new_j++;
                else{
                    queenStack.push(newPosition);
                    i++;
                    n++;
                    if(n==8)
                        return true;
                    break;
                }
                if(new_j>7){
                    Queen oldPosition = queenStack.pop();
                    n--;
                    new_j = oldPosition.j+1;
                }
            }
            if(queenStack.isEmpty()){
                j++;
            }

        }

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        if(solution.getEightQueenSolution())
            System.out.println("Hurray Solution found");
        else
            System.out.println("No solution found");
    }
}
