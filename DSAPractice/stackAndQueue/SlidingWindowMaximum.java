package DSAPractice.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.println("enter the size of array");
        int sizeArray = scn.nextInt();

        int[] arr = new int[sizeArray];
        System.out.println("enter the value in the array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("enter the window size: ");
        int windowSize = scn.nextInt();

        // find NGE
        Stack<Integer> stackNge = new Stack<>();
        int[] ngeArray = new int[sizeArray];

        for(int i = arr.length - 1; i >= 0; i--){
            if(i == arr.length - 1){
                stackNge.push(i);
                ngeArray[i] = arr.length;
            } else {
                while(!stackNge.isEmpty() && arr[i] >= arr[stackNge.peek()]){
                    stackNge.pop();
                }
                if(stackNge.isEmpty()){
                    ngeArray[i] = arr.length;
                } else {
                    ngeArray[i] = stackNge.peek();
                }

                stackNge.push(i);
            }
        }

        // find the max in the window
        for(int i = 0; i <= arr.length - windowSize; i++){
            int maxInWindow = i;
            while(ngeArray[maxInWindow] < i + windowSize){
                maxInWindow = ngeArray[maxInWindow];
            }
            System.out.println(arr[maxInWindow]);
        }

        scn.close();
    }
}