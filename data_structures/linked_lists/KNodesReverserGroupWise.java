package data_structures.linked_lists;

import static data_structures.linked_lists.Node.printList;

public class KNodesReverserGroupWise {
    public static Node reverseKGroup(Node head, int k) {
        if ( head == null || head.next == null || k ==1 ){
            return head;
        }
        int i=0;
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node begin = dummyHead;
        while ( head != null ){
            i++;
            if ( i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else{
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    private static Node reverse(Node begin, Node end) {
        Node cur = begin.next;
        Node next, first;
        Node prev = begin;
        first = cur;
        while ( cur!= end ){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur;
        return first;
    }

    public static void main(String[] args){
        Node head = new Node(0);
        Node node = head;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
        }
        printList(head);
        Node newHead = reverseKGroup(head, 3);
        printList(newHead);
    }
}
