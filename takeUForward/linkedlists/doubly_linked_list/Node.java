package takeUForward.linkedlists.doubly_linked_list;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    public Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
