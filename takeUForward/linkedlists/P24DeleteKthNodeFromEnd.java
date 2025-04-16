package takeUForward.linkedlists;

public class P24DeleteKthNodeFromEnd {
    public static Node removeKthNode(Node head, int K)
    {
        Node fast = head;
        for ( int i=0; i<K; i++) fast = fast.next;
        Node slow = head;
        while ( fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next;
        }
        if ( fast == null) return head.next;
        slow.next = slow.next.next;
        return head;
    }
}
