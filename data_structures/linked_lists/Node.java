package data_structures.linked_lists;

public class Node<T> {
    public T data;
    Node next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public static void printList(Node head) {
        if ( head == null ) return;
        Node cur = head;
        while ( cur != null ){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
