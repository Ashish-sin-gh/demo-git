/*
 * question - you are given n number of people in the party and they are forming a n X n metrics that have the familiarity status of them. find the celebrity - someone who does not know anyone but everyone knows him 
 * 
 * 
 * use elemination method on the people in the party stack to get to the final possible celebrity then test that final possible celebrity with every other person to know if he is acutal celebrity or not
 * 
 * this will to complete the probem in O(n) 
 * 
 */

package DSAPractice.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number of people present in the party: ");
        int partyPeople = Integer.parseInt(br.readLine());

        int[][] arr = new int[partyPeople][partyPeople];

        // populate the matrix
        for(int i = 0; i < partyPeople; i++){
            System.out.println("enter the status: ");
            String line = br.readLine();

            for(int j = 0; j < partyPeople; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Stack<Integer> psStack = new Stack<>();

        // push all people in the stack
        for (int i = 0; i < partyPeople; i++) {
            psStack.push(i);
        }

        // find possible celebrity
        while(psStack.size() > 1){
            int n1 = psStack.pop();
            int n2 = psStack.pop();

            if(arr[n1][n2] == 1){
                psStack.push(n2);
            } else {
                psStack.push(n1);
            }
        }

        // sure celebrity check
        int pc = psStack.pop();

        for(int i = 0; i < partyPeople; i++){
            if(i != pc){
                if(arr[i][pc] != 1 || arr[pc][i] != 0){
                    System.out.println("no celebrity");
                    return;
                }
            }
        }
        System.out.println("\ncelebirty is "+ pc);

    }
}
