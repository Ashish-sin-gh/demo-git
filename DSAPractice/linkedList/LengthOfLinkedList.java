package DSAPractice.linkedList;

public class LengthOfLinkedList {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        Node head = new Node(arr[0]);
        Node moveablePointer = head;

        for(int i = 1; i < arr.length; i++){
            Node unlinkedNextNode = new Node(arr[i]);
            moveablePointer.next = unlinkedNextNode;
            moveablePointer = unlinkedNextNode; 
        }

        Node lengthCheckerLL = head;
        int count = 0;  
        while(lengthCheckerLL != null){
            count++;
            lengthCheckerLL = lengthCheckerLL.next;
        }
        System.out.println("length: " + count);
    }

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }
}
