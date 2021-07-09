package data_structures.linked_lists;

public class ReverseEveryKElementSublist {
    public static Node reverseKSublists(Node head, int k) {
        if ( k <=1 || head == null ) return head;
        Node cur = head, prev = null;

        while ( true ){
            Node lastNodeOfPrevPart = prev;
            Node lastNodeOfSublist = cur;
            Node next = null;
            int i =0;
            while ( i <k && cur!= null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if ( lastNodeOfPrevPart != null ){
                lastNodeOfPrevPart.next = prev;
            }
            else{
                head = prev;
            }
            if ( cur == null ) break;
            prev = lastNodeOfSublist;
        }
        return head;
    }
}
