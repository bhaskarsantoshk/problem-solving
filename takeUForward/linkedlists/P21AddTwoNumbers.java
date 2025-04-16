package takeUForward.linkedlists;

public class P21AddTwoNumbers {

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
       int carry = 0;
       LinkedListNode cur1 = head1;
       LinkedListNode cur2 = head2;
       LinkedListNode res = new LinkedListNode(0);
       LinkedListNode dummy = res;
       while ( cur1 != null && cur2 != null){
           int sum = cur1.data + cur2.data + carry;
           res.next = new LinkedListNode(sum%10);
           res = res.next;
           cur1 = cur1.next;
           cur2 = cur2.next;
           carry = sum/10;
       }

       while ( cur1 != null){
           int sum = carry + cur1.data;
           res.next = new LinkedListNode( sum % 10);
           carry = sum /10;
           res = res.next;
           cur1 = cur1.next;
       }
        while ( cur2 != null){
            int sum = carry + cur2.data;
            res.next = new LinkedListNode( sum % 10);
            carry = sum /10;
            res = res.next;
            cur2 = cur2.next;
        }
        if ( carry > 0){
            res.next = new LinkedListNode(carry);
        }
        return dummy.next;
    }

    static LinkedListNode addTwoNumbers2(LinkedListNode head1, LinkedListNode head2) {
        int carry = 0;
        LinkedListNode cur1 = head1;
        LinkedListNode cur2 = head2;
        LinkedListNode res = new LinkedListNode(0);
        LinkedListNode dummy = res;
        while ( cur1 != null || cur2 != null || carry > 0){
            int sum = carry;
            if ( cur1 != null) {
                sum+= cur1.data;
                cur1 = cur1.next;
            }
            if ( cur2 != null){
                sum += cur2.data;
                cur2 = cur2.next;
            }
            res.next = new LinkedListNode(sum%10);
            res = res.next;
            carry = sum/10;
        }
        return dummy.next;
    }

}
