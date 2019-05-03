package microsoft;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode cur= new ListNode(0);
        ListNode temp = cur;

        while(a!=null && b!=null){
            if(a.val < b.val){
                cur.next=a;
                a=a.next;
            }
            else{
                cur.next=b;
                b=b.next;
            }
            cur=cur.next;
        }

        if(a!=null){
            cur.next=a;
        }
        if(b!=null){
            cur.next=b;
        }

        return temp.next;
    }
}
