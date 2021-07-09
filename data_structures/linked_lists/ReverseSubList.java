package data_structures.linked_lists;

public class ReverseSubList {
    public Node reverseSubList(Node head, int p, int q){
        if ( p == q ) return head;
        Node cur = head, prev = null;
        int i = 0;
        while ( cur != null && i < p-1){
            prev = cur;
            cur = cur.next;
            i++;
        }

        // consider 3 parts , 1. part before index p 2. part between p and q 3. part after q

        Node lastNodeOfPart1 = prev;

        // after reversing part2, current will be the last node of sublist

        Node lastNodeOfSublist = cur;

        Node next = null; // will be used to temporarily store next node during reversing

        i = 0;
        while ( cur != null && i < q-p+1){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // connect with first part
        if ( lastNodeOfPart1 != null ){
            lastNodeOfPart1.next = prev; // prev is the first node of sublist
        }
        else {
            head = prev;
        }
        lastNodeOfSublist = cur;
        return head;
    }
}
