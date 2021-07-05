package data_structures.linked_lists;

public class LengthOfALinkedList {

    public int length(Node head){
        if ( head == null ) return 0;
        int len = 0;
        Node cur = head;
        while ( cur.next != null ){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
