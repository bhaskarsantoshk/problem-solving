package takeUForward.linkedlists;

import java.util.Stack;

public class P26CheckIfLinkedListIsPalindrome {
    public static boolean isPalindromeBruteForce(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while ( cur != null){
            stack.push(cur.data);
            cur = cur.next;
        }
        cur = head;
        while ( cur != null && !stack.isEmpty()){
            int val = stack.pop();
            if ( val != cur.data) return false;
            cur = cur.next;
        }

        if ( cur != null || !stack.isEmpty()) return false;
        return true;
    }

    public static boolean isPalindrome(Node head) {
        if ( head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while ( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverse(slow.next);
        Node first = head;
        Node second = newHead;
        while ( second != null){
            if ( first.data != second.data ){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    private static Node reverse(Node head) {
        if ( head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        while ( cur != null ) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
