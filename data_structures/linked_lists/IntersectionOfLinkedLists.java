package data_structures.linked_lists;

import java.util.HashSet;
import java.util.Set;

import static data_structures.linked_lists.Node.printList;

public class IntersectionOfLinkedLists {
    public static void main(String[] args){
        Node head1 = new Node(0);
        Node node = head1;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
        }
        Node head2 = new Node(0);
        Node node2 = head2;
        for ( int i=0; i<6; i++){
            node2.next = new Node(i*2);
            node2 = node2.next;
        }
        printList(head1);
        printList(head2);
        Node res = intersection(head1, head2);
        printList(res);
    }

    private static Node intersection(Node list1, Node list2) {
       Node res = null;
       if ( list1 == null || list2 == null ){
           return null;
       }
       Node cur = list1;
       while ( cur != null ){
           if ( contains(list2, (Integer)cur.data)){
               res = insertAtHead(res, (Integer) cur.data);
           }
           cur = cur.next;
       }
       return res;
    }

    private static Node insertAtHead(Node head, int data) {
        Node res = new Node(data);
        if ( head == null ){
            return res;
        }
        res.next = head;
        return res;
    }

    private static boolean contains(Node node, int data) {
        while ( node != null ){
            if ( node.data.equals(data) ) return true;
            node = node.next;
        }
        return false;
    }
}
