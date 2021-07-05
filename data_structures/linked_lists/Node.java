package data_structures.linked_lists;

public class Node<T> {
    public T data;
    Node next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
