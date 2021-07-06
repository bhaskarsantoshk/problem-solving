package data_structures.linked_lists;

import static data_structures.linked_lists.Node.printList;

public class RemoveDuplicatesFromASortedLinkedList {
    public static void removeDuplicatesFromSortedList(Node head){
        Node cur = head;
        while ( cur != null && cur.next != null ){
            if ( cur.data.equals(cur.next.data)){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
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
            node.next = new Node(i+1);
            node = node.next;
        }
        printList(head);
        removeDuplicatesFromSortedList(head);
        printList(head);
    }
}
