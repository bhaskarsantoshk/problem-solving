package microsoft;

public class PalindromeList {
    public int lPalin(ListNode head) {

        if(head == null || head.next== null) return 1;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode secondHead= slow.next;
        ListNode p1 = secondHead;
        ListNode p2= p1.next;


        while(p1!=null && p2!=null){
            ListNode temp= p2.next;
            p2.next = p1;
            p1= p2;
            p2= temp;
        }

        secondHead.next = null;
        ListNode p = (p1== null) ? p2: p1;
        ListNode q = head;

        while(p!=null){
            if(p.val != q.val){
                return 0;
            }

            p = p.next;
            q=q.next;
        }

        return 1;
    }
}
