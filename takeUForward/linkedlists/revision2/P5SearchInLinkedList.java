package takeUForward.linkedlists.revision2;

public class P5SearchInLinkedList {
    public boolean searchKey(ListNode head, int key) {
        ListNode cur = head;
        while ( cur != null){
            if (cur.data == key) return true;
            cur = cur.next;
        }
        return false;
    }
}
