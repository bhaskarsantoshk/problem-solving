package data_structures.linked_lists;

import java.util.HashSet;
import java.util.Set;

import static data_structures.linked_lists.Node.printList;

public class RemoveDuplicatesFromLinkedList {
    public static void removeDuplicates ( Node head ){
        Node cur = head;
        Node compare = null; // runs and compares in inner loop
        while ( cur != null && cur.next != null ){
            compare = cur;
            while ( compare.next != null ){
                if ( cur.data.equals(compare.next.data) ){
                    compare.next = compare.next.next;
                }
                else{
                    compare = compare.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        Node head = new Node(0);
        Node node = head;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
            node.next = new Node(i+1);
            node = node.next;
        }
        printList(head);
        removeDuplicates(head);
        printList(head);
    }
}
