// in java we dont need to delete the node as it has smart garbage collector that will automatically delete the node which wont be having a reference to it

// in c++ you have to explicitly free the data from the heap - 
// free(reference variable)

package linkedList;

public class DeleteFromLinkedList {

    public static class Node {
        int data;
        Node nextNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;
        }

        Node(int data, Node next){
            this.data = data;
            this.nextNode = next;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        Node head = new Node(arr[0]);
        Node moveableHeader = head;

        for(int i = 1; i < arr.length; i++){
            Node unlistedNode = new Node(arr[i]);
            moveableHeader.nextNode = unlistedNode;
            moveableHeader = unlistedNode;
        }

        // delete the head -> just move the head to the second node
        head = head.nextNode; 
        // reference to first node is moved to second node hence there is no refernce left in the first node - and in future time it will be deleted form the heap

        Node printableNode = head;

        while(printableNode !=null){
            System.out.print(printableNode.data + "\t");
            printableNode = printableNode.nextNode;
        }
    }
}

