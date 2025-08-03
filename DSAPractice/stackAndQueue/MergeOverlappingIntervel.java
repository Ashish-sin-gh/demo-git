package DSAPractice.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number of meetings: ");
        int totalMeeting = Integer.parseInt(br.readLine());

        int[][] meetingIntervals = new int[totalMeeting][2];

        for(int meeting = 0; meeting < totalMeeting; meeting++){
            String line = br.readLine();
            String[] split = line.split(" " );

            meetingIntervals[meeting][0] = Integer.parseInt(split[0]);
            meetingIntervals[meeting][1] = Integer.parseInt(split[1]);
        }

        /*
        for(int i = 0; i < meetingIntervals.length; i++){
            for (int j = 0; j < meetingIntervals[i].length; j++){
                System.out.print(meetingIntervals[i][j] + " ");
            }
            System.out.println();
        }
        */
        
        // make array of Pair type
        Pair[] pairs = new Pair[meetingIntervals.length];
        // populate the array with pairs (value)
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = new Pair(meetingIntervals[i][0], meetingIntervals[i][1]);
        }
        // sort the array against fist element
        // we will use Comparable Interface for this
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<>();

        for(int i = 0; i < pairs.length; i++ ){
            if(i == 0){
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                if(pairs[i].startInterval > top.endInterval){
                    st.push(pairs[i]);
                }else{
                    top.endInterval = Math.max(top.endInterval, pairs[i].endInterval);
                }
            }
        }

        Stack<Pair> reversedStack = new Stack<>();
        while(!st.isEmpty()){
            reversedStack.push(st.pop());
        }

        while(!reversedStack.isEmpty()){
            Pair p = reversedStack.pop();
            System.out.println(p);
        }
    }

    // why this class - coz you want to sort the pair (object) which isnt possible implecitly like sorting an int array
    public static class Pair implements Comparable<Pair>{
        int startInterval;
        int endInterval;

        Pair(int si, int ei){
            this.startInterval = si;
            this.endInterval = si;
        }

        
        @Override
        //this > other return +ve
        //this == other return 0
        //this < other return -ve
        public int compareTo(Pair other){
            if(this.startInterval != other.startInterval){
                return this.startInterval - other.startInterval;
            } else {
                return this.endInterval - other.endInterval;
            }
        }
    }
}
