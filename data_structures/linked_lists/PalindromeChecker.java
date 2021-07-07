package data_structures.linked_lists;

import static data_structures.linked_lists.DoublyListNode.printList;

public class PalindromeChecker {
    public static boolean isPalindrome(DoublyListNode head){
        if ( head == null ) return true;
        DoublyListNode end = head;
        while ( end.next != null ){
            end = end.next;
        }
        DoublyListNode start = head;
        while ( start!= null && end!= null && !start.equals(end)){
            if ( start.data != end.data ){
                return false;
            }
            start = start.next;
            end = end.prev;
        }
        return true;
    }

    public static void main(String[] args){
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode node = head;
        for ( int i=0; i<3; i++){
            node.next = new DoublyListNode(i+1);
            node = node.next;
        }
        for ( int i=3; i>=0 ; i--){
            node.next = new DoublyListNode(i+1);
            node = node.next;
        }
         node.next = new DoublyListNode(0);
        printList(head);
        System.out.println(isPalindrome(head));
    }
}

// 1 2 3 2 1
// 1 2 3 3 2 1