package DSAPractice.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                operatorStack.push(ch);

            } else if(Character.isDigit(ch)){
                operandStack.push(ch - '0');

            } else if(ch == ')'){
                while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                    char operator = operatorStack.pop();

                    int operand1 = operandStack.pop();
                    int operand2 = operandStack.pop();

                    int calculatedValue = operation(operand2, operand1, operator);

                    operandStack.push(calculatedValue);
                }
                operatorStack.pop();

            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && precedence(operatorStack.peek()) >= precedence(ch)){
                    char operator = operatorStack.pop();

                    int operand1 = operandStack.pop();
                    int operand2 = operandStack.pop();

                    int calculatedValue = operation(operand2, operand1, operator);

                    operandStack.push(calculatedValue);
                }
                operatorStack.push(ch);

            }
        }
        while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();

            int operand1 = operandStack.pop();
            int operand2 = operandStack.pop();

            int calculatedValue = operation(operand2, operand1, operator);

            operandStack.push(calculatedValue);
        }

        System.out.println("output is: " + operandStack.peek());
    }

    public static int operation(int num1, int num2, char ch){
        return switch (ch) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> num1 / num2;
        };
    }

    public static int precedence(char ch){
        return switch(ch){
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            default -> 2;
        };
    }
}
