package DSAPractice.stackAndQueue;

public class CustomQueue {
    public static void main(String[] agrs){
        MyQueue q = new MyQueue(5);
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }

    public static class MyQueue{
        int startPointer;
        int endPointer;
        int lengthOfQueue;
        int counter;
        int[] queueArray;

        public MyQueue(int length) {
            this.lengthOfQueue = length;
            this.startPointer = -1;
            this.endPointer = -1;
            int counter = 0;
            this.queueArray = new int[this.lengthOfQueue];
        }

        // check queue empty or not
        public boolean isEmpty(){
            return this.counter == 0;
        }

        //check queue full or not
        public boolean isFull(){
            return this.counter == this.lengthOfQueue;
        }

        //push element
        public void push(int value){
            if(!this.isFull()){
                this.endPointer = (this.endPointer+1)%this.lengthOfQueue;
                queueArray[this.endPointer] = value;
                this.counter++;
            } else {
                System.out.print("Queue is full: cant enter " + value);
            }
        }

        //pop element
        public int pop(){
            if(!this.isEmpty()){
                this.startPointer = (this.startPointer + 1) %  this.startPointer;
                int storeELement = queueArray[this.startPointer];  
                if(this.counter == 1){
                    this.startPointer = -1;
                    this.endPointer = -1;
                } 
                this.counter--;
                return storeELement; 
            } else {
                System.err.println("queue is empty: cant pop any more element");
                return -1;
            }
        }

        
    }
}
