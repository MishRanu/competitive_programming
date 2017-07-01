package permutationstring;

import java.util.Scanner;

/**
 * Created by User on 01-Jul-17.
 */
public class Solution {
    public String input;

    Solution(String input){
        this.input = input;
    }
    private void permute(String permute){
        permute("", permute);
    }

    private void permute(String prefix, String str){
    if(str.length()==0){
        System.out.println(prefix);
    }
    else{
        for(int i=0; i<str.length(); i++){
          permute(prefix + str.charAt(i), str.substring(0,i)+str.substring(i+1,str.length()));
        }
    }
    }


    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        Solution solution = new Solution(stdin.next());
        solution.permute(solution.input);
    }

}
