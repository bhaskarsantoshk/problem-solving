package Recursion;

public class LinkedListSearch {
    public static boolean search(ListNode head, int key){
        if ( head == null ){
            return false;
        }
        if (head.data == key ){
            return true;
        }
        return search(head.next, key);
    }
}
