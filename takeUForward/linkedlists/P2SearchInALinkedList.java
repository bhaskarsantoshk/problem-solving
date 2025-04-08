package takeUForward.linkedlists;

public class P2SearchInALinkedList {
    public static int searchInLinkedList(Node head, int k)
    {
        Node cur = head;
        while ( cur != null ){
            if ( cur.data == k) return 1;
            cur = cur.next;
        }
        return 0;
    }
}
