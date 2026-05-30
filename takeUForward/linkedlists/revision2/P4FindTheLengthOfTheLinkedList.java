package takeUForward.linkedlists.revision2;

public class P4FindTheLengthOfTheLinkedList {
    public int getLength(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while ( cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
}
