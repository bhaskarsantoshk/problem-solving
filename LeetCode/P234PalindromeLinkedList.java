package LeetCode;

public class P234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next== null ) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        ListNode a = reverseList(newHead);
        ListNode b = head;

        while(a!= null && b!= null){
            if(a.val != b.val){
                return false;
            }
            a= a.next;
            b= b.next;
        }
        return true;

    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
