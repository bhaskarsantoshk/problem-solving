package data_structures.linked_lists;

public class DeletionInASinglyLinkedList<T> {
    public Node head;
    public void deleteByValue ( T data){
        if ( head == null ){
            return;
        }

        Node cur = head;
        Node prev = null;
        if (cur.data.equals(data)){
            deleteAtHead();
            return;
        }
        while ( cur != null ){
            if ( cur.data.equals(data)){
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    private void deleteAtHead() {
        if (head == null ){
            return;
        }
        head = head.next;
    }
}
