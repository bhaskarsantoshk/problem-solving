package microsoft;

public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode head) {
            if(head == null || head.next== null) return head;
            ListNode temp = new ListNode(0);
            temp.next = head;
            ListNode cur = temp;


            while(cur.next!= null && cur.next.next!=null){
                ListNode firstNode = cur.next;
                ListNode secondNode = cur.next.next;

                firstNode.next= secondNode.next;
                cur.next = secondNode;
                cur.next.next = firstNode;
                cur = firstNode;
            }

            return temp.next;
    }
}
