package Recursion;

import static Recursion.Print.print;

public class LinkedList {
    public static int lengthOfLinkedList(ListNode head){
        ListNode node = head;
        int count = 0;
        while (node != null ){
            count++;
            node = node.next;
        }
        return count;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        print(lengthOfLinkedList(head));
        print(lengthOfListRecursive(head));
    }

    public static int lengthOfListRecursive ( ListNode head){
        if ( head == null ){
            return 0;
        }
        return 1+ lengthOfListRecursive(head.next);
    }
}
