package linkedList;

public class AtLl {
    public static void main(String[] args){
        int[] arr = {6,9,8,2,5,7};

        Node head = new Node(arr[0]);
        Node moveablePointer = head;

        for(int i = 1; i < arr.length; i++){
            Node unLinkedNode = new Node(arr[i]); // holding reference of next node
            moveablePointer.nextNode = unLinkedNode; // created a link
            moveablePointer = moveablePointer.nextNode;
        }

        Node linkedListTraversal = head;
        while(linkedListTraversal != null){
            System.out.print(linkedListTraversal.data + "\t");
            linkedListTraversal = linkedListTraversal.nextNode;
        }

    }

    public static class Node{
        int data;
        Node nextNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }
}
