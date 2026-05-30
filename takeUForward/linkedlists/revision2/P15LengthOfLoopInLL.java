package takeUForward.linkedlists.revision2;

public class P15LengthOfLoopInLL {
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

    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if ( slow == fast){
                int count = 1;
                ListNode temp = fast;
                fast = fast.next;
                while ( temp != fast){
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}
