package bytebybyte;

public class PrintReverseLinkedList {

    public void printReverse (Node node){
        if ( node == null ){
            return;
        }
        printReverse(node.next);
        System.out.println(node.data);
    }

    private class Node{
        int data;
        Node next;
    }
}

// Decide if we have to reverse linked list and print
// Recursive printing
