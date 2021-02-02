package bytebybyte;

public class SpliLinkedList {

    public Node divide(Node head){
        if ( head == null ) return null;
        Node cur = head;
        Node runner = head.next;
        while (runner != null && runner.next != null){
            runner = runner.next.next;
            cur = cur.next;
        }
        Node result = cur.next; // head of divided list
        cur.next = null;
        return result;
    }

    private class Node{
        int data;
        Node next;
    }
}

// We need to divide the list into two halves
// questions: how about an odd numbered list ? - consider this edge case and ask question
// approach : slow and fast pointer
// start by taking slow at head , fast at head.next - since we need slow one before half so we can remove link

