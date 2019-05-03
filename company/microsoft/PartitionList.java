package company.microsoft;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode p = head;
        while(p!= null){
            if(p.val < x){
                cur1.next=p;
                cur1= p;
            }
            else{
                cur2.next = p;
                cur2=p;
            }
            p=p.next;
        }

        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
