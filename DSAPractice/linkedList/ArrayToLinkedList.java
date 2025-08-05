package DSAPractice.linkedList;

public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        Node head  = new Node(arr[0]);
        Node mover = head;
        
        int i = 1;
        while(i < arr.length){
            Node nextNodeRef = new Node(arr[i]);
            mover.nextNode = nextNodeRef; // mover is on previous node - from therer mover will store nextNode reference in itself to make it  linked list 
            mover = nextNodeRef;
            i++;
        }

        // traverse a linked list 
        Node linkedList = head;
        while(linkedList != null){
            System.out.println(linkedList.data);
            linkedList = linkedList.nextNode;
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
