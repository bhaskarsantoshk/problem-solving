package data_structures.linked_lists;

import LeetCode.ListNode;

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head){
        Node newHead = null;
        Node cur = head;
        while ( cur != null ){
            Node next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    public static Node reverseLinkedListRecursive(Node head){
        if ( head == null || head.next == null ) return head;
        Node secondNode = head.next;
        head.next = null;
        Node reverseRest = reverseLinkedListRecursive(secondNode);
        secondNode.next = head;
        return reverseRest;
    }

    public static void main(String[] args){
        Node head = new Node(0);
        Node node = head;
        for ( int i=0; i<5; i++){
            node.next = new Node(i+1);
            node = node.next;
        }
        printList(head);
        Node reverseHead = reverseLinkedListRecursive(head);
        printList(reverseHead);
    }

    private static void printList(Node head) {
        if ( head == null ) return;
        Node cur = head;
        while ( cur != null ){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
