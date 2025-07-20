package DSAPractice.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // inputStreamReader is used to convert byte stream to character stream
        String infix = br.readLine();

        Stack<String> prefixStack = new Stack<>(); 
        Stack<String> postfixStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);
            
            if(ch == '('){
                operatorStack.push(ch);

            } else if(Character.isDigit(ch)){
                prefixStack.push(Character.toString(ch));
                postfixStack.push(Character.toString(ch));


            } else if(ch == ')'){
                while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                    char operator = operatorStack.pop();

                    String num1prefixStack = prefixStack.pop();
                    String num2prefixStack = prefixStack.pop();
                    String answer1 = operator + num2prefixStack + num1prefixStack;
                    prefixStack.push(answer1);

                    String num1postfixStack = postfixStack.pop();
                    String num2postfixStack = postfixStack.pop();
                    String answer2 = num2postfixStack + num1postfixStack + operator;
                    postfixStack.push(answer2);
                }
                operatorStack.pop();

            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(!operatorStack.isEmpty() && precedence(ch) <= precedence( operatorStack.peek()) && operatorStack.peek() != '('){
                    char operator = operatorStack.pop();

                    String num1prefixStack = prefixStack.pop();
                    String num2prefixStack = prefixStack.pop();
                    String answer1 = operator + num2prefixStack + num1prefixStack;
                    prefixStack.push(answer1);

                    String num1postfixStack = postfixStack.pop();
                    String num2postfixStack = postfixStack.pop();
                    String answer2 = num2postfixStack + num1postfixStack + operator;
                    postfixStack.push(answer2);
                }
                operatorStack.push(ch);
            }
        }

        while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();

            String num1prefixStack = prefixStack.pop();
            String num2prefixStack = prefixStack.pop();
            String answer1 = operator + num2prefixStack + num1prefixStack;
            prefixStack.push(answer1);

            String num1postfixStack = postfixStack.pop();
            String num2postfixStack = postfixStack.pop();
            String answer2 = num2postfixStack + num1postfixStack + operator;
            postfixStack.push(answer2);
        }

        System.out.println("prefix - " + prefixStack.peek());
        System.out.println("postfix - " + postfixStack.peek());
    }

    public static int precedence( char ch ){
        return switch(ch){
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            default -> 0;
        };
    }
}
