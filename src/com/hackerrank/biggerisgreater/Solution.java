package biggerisgreater;

import java.io.*;
import java.util.ArrayList;

public class Solution {
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

    private void swap(StringBuffer input, int index, int i){
        char temp = input.charAt(index);
        input.setCharAt(index, input.charAt(i));
        input.setCharAt(i, temp);
    }

    private void permute(StringBuffer input, int index){
        if(index>=input.length()){
            this.permuteInputs.add(input.toString());
        }
        else {
            for(int i=index; i<input.length(); i++){
                swap(input, index, i);
                permute(input, index+1);
                swap(input, index, i);
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
//            permute("", input.substring(i));
            permute(new StringBuffer(input.substring(i)), 0);
            String result = getMin(input, this.permuteInputs);
            this.permuteInputs.clear();
            if(!result.equals("")){
                return result;
            }
        }
        return "no answer";
    }

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution solution = new Solution();
        int n = Integer.parseInt(stdin.readLine());

        solution.inputs = new String[n];
        for(int i=0; i<n; i++){
            solution.inputs[i] = stdin.readLine();
            solution.inputs[i] = solution.processString(solution.inputs[i]);
        }
        for(int i=0; i<n; i++) {
            out.write(solution.inputs[i]+"\n");
//            System.out.println(solution.inputs[i]);
        }
        out.flush();
    }
}
