import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SmallestNumberFllowingPattern {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the alphabet pattern(d and i): ");
        String alphabetPattern = br.readLine();

        Stack<Character> apStack = new Stack<>();
        Stack<Integer> numPatternStack = new Stack<>();

        int count = 1;

        for(int i = 0; i < alphabetPattern.length(); i++){
            char ch = alphabetPattern.charAt(i);

            if(ch == 'd'){
                count++;
                apStack.push(ch);
            }
            if(ch == 'i'){
                int number = count ;
                while(!apStack.isEmpty() && apStack.peek() != 'i'){
                    numPatternStack.push(number);
                    apStack.pop();
                    number--;
                }
                numPatternStack.push(number);
                apStack.push(ch);
                count++;
            }
        }

        int number = count;
        while(!apStack.isEmpty()){
            numPatternStack.push(number);
            number--;
            apStack.pop();
        }
        numPatternStack.push(number);

        Stack<Integer> outputStack = new Stack<>();
        
        while(!numPatternStack.isEmpty()){
            outputStack.push(numPatternStack.pop());
        }

        while(!outputStack.isEmpty()){
            System.out.println(outputStack.pop());
        }
    }
}

