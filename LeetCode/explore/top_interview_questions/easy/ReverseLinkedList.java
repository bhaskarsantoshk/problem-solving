package LeetCode.explore.top_interview_questions.easy;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
