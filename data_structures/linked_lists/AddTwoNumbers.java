package data_structures.linked_lists;

public class AddTwoNumbers {
    public Node addTwoNumbers ( Node l1, Node l2){
        Node dummyHead = new Node(-1);
        Node res = dummyHead;
        int carry = 0;

        while ( l1 != null || l2 != null ){
            int sum = (Integer) (l1 != null ? l1.data : 0) + (Integer)(l2!= null ? l2.data : 0) + carry;
            res.next = new Node(sum%10);
            carry = sum/10;
            l1 = ( l1 != null ? l1.next : l1);
            l2 = ( l2 != null ? l2.next : l2);
            res = res.next;
        }
        if ( carry == 1){
            res.next = new Node(1);
        }
        return dummyHead.next;
    }
}
