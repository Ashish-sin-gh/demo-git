package linkedList;

public class SearchInLinkedList {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int key = 4;

        Node head = new Node(arr[0]);
        Node moveablePointer = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            moveablePointer.next = temp;
            moveablePointer = temp;
        }

        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                System.out.println("found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("not found");
    }

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
