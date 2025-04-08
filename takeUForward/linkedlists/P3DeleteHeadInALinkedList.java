package takeUForward.linkedlists;

public class P3DeleteHeadInALinkedList {
    public static Node deleteHead(Node head) {
        if ( head == null ) return null;
        return head.next;
    }
}
