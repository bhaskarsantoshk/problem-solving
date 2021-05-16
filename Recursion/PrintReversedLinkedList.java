package Recursion;

public class PrintReversedLinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printReversedLinkedList(head);
    }

    private static void printReversedLinkedList(ListNode head) {
        if ( head == null ) return;
        printReversedLinkedList(head.next);
        System.out.println(head.data);
    }
}
