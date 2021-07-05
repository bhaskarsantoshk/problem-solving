package data_structures.linked_lists;

public class InsertAtEnd<T> {
    public Node head;

    public void insertAtEnd(T data) {
        if ( head == null ){
            head = new Node(data);
        }
        else {
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data);
        }

    }
}
