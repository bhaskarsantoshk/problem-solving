package takeUForward.linkedlists;

public class P25ReverseALinkedList {
    public static Node reverseLinkedList(Node head)
    {
        Node cur = head;
        Node prev = null;
        while ( cur != null ){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static Node reverseLinkedListRecursive(Node head)
    {
        // base case
        if ( head == null || head.next == null) return head;

        //rec
        Node newHead = reverseLinkedListRecursive(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
