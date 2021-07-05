package data_structures.linked_lists;

public class SearchInASinglyLinkedList<T> {
    public Node head;
    public boolean search(T data){
        if ( head == null ){
            return false;
        }
        Node cur = head;
        while ( cur.next != null ){
            if ( cur.data.equals(data) ){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
