package biggerisgreater;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 01-Jul-17.
 */
public class Solution {
    int test_cases;
    String[] inputs;
    ArrayList<String> permuteInputs = new ArrayList<>();

    public void permute(String prefix, String str){
        if(str.length()==0) {
            this.permuteInputs.add(prefix);
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                permute(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1,str.length()));
            }
        }
    }

    private int calcValue(String input){
        int val = 0;
        int pow_10=1;
        for(int i=input.length()-1; i>=0; i--){
            val+= input.charAt(i)*pow_10;
            pow_10*=10;
        }
        return val;
    }

    public String getMin(String input, ArrayList<String> permuteStrings){
        int min = calcValue(input);
        int opt_val= Integer.MAX_VALUE;
        String answer = "";
        for(String permuteString: permuteStrings){
            int curr_val = calcValue(permuteString);
            if(curr_val>min){
                if(curr_val<opt_val) {
                    opt_val = curr_val;
                    answer = permuteString;
                }
            }
        }
        return answer;
    }

    public String processString(String input){
        for(int i=input.length()-2; i>=0; i--) {
            permute("", input.substring(i));
            String result = getMin(input, this.permuteInputs);
            this.permuteInputs.clear();
            if(!result.equals("")){
                return result;
            }
        }
        return "no answer";
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Solution solution = new Solution();
        solution.test_cases = stdin.nextInt();

        solution.inputs = new String[solution.test_cases];
        for(int i=0; i<solution.test_cases; i++){
            solution.inputs[i] = stdin.next();
            solution.inputs[i] = solution.processString(solution.inputs[i]);
        }
        for(int i=0; i<solution.test_cases; i++) {
            System.out.println(solution.inputs[i]);
        }
//        System.out.println(solution.inputs[0]);
    }
}
