package takeUForward.linkedlists.revision2;

public class P14FindTheStartingPointInLL {
    public ListNode findStartingPoint(ListNode head) {
        ListNode slow = head, fast = head;
        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast){
                slow = head;
                while ( slow != fast ){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }
}
