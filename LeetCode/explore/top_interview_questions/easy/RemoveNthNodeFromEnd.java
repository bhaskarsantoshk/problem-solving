package LeetCode.explore.top_interview_questions.easy;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null || n == 0) return head;
        ListNode fast = head;
        for ( int i=0; i<n; i++){
            if (fast == null ){
                return head;
            }
            fast = fast.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode slow = dummyHead;
        slow.next = head;
        while ( fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
