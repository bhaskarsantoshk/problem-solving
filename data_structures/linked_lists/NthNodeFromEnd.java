package data_structures.linked_lists;

import static data_structures.linked_lists.Node.printList;

public class NthNodeFromEnd {
    public static Node nthNodeFromEnd (Node head , int n){
        Node fast = head;
        for ( int i=0; i<n; i++){
            if ( fast == null ){
                return null;
            }
            fast = fast.next;
        }
        Node slow = head;
        while ( fast != null ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // n + x = k
    // x = k - n


    public static void main(String[] args){
        Node head = new Node(0);
        Node node = head;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
        }
        printList(head);
        System.out.println(nthNodeFromEnd(head, 3).data);
    }
}
