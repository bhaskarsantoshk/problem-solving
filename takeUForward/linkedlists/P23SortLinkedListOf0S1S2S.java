package takeUForward.linkedlists;

public class P23SortLinkedListOf0S1S2S {
    public static Node sortList(Node head) {
        if ( head == null || head.next == null) return head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node cur = head;
        while ( cur != null ){
            if ( cur.data == 0){
                zero.next = cur;
                zero = zero.next;
            } else if ( cur.data == 1){
                one.next = cur;
                one = one.next;
            } else {
                two.next = cur;
                two = two.next;
            }
            cur = cur.next;
        }
        zero.next = ( oneHead.next != null ) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
}
