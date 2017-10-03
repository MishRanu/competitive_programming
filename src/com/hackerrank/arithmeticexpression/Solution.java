package arithmeticexpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 * Created by User on 25-Sep-17.
 */
public class Solution {
    ArrayList<Character> precedence = new ArrayList<>();
    Stack<Integer> operandStack = new Stack<>();
    Stack<Character> operatorStack = new Stack<>();

    Solution(){
        precedence.add('+');
        precedence.add('-');
        precedence.add('*');
        precedence.add('/');
    }

    public boolean hasPrecedence(Character op1, Character op2){
        return precedence.indexOf(op2)>=precedence.indexOf(op1);
    }

    public int compute(int operand1, int operand2, char operator){
        switch(operator){
            case '-': return operand2 - operand1;
            case '+': return operand2 + operand1;
            case '*': return operand2*operand1;
            case '/': return operand2/operand1;
            default: throw new NoSuchElementException();
        }
    }

    public int evalExpression(String[] input){
        for(String key: input){
            if(key.toCharArray()[0]>='0'&&key.toCharArray()[0]<='9'){
                operandStack.add(Integer.parseInt(key));
            }
            else{
                while(!operatorStack.isEmpty()&&hasPrecedence(key.toCharArray()[0], operatorStack.peek())){
                    operandStack.push(compute(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
                }
                operatorStack.push(key.toCharArray()[0]);
            }

        }
        while(!operatorStack.isEmpty()){
            operandStack.push(compute(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
        }

        if(!operandStack.isEmpty())
            return operandStack.pop();

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        String expression = in.readLine();
        String[] inputArray = expression.split("\\s+");

        Solution solution  = new Solution();
        System.out.println(solution.evalExpression(inputArray));

    }
}
